package vn.iotstar.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.iotstar.model.CategoryModel;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.util.Constant;

@WebServlet(urlPatterns = { "/admin/category/add" })
public class CategoryAddController extends HttpServlet {
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/addCate.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse
	resp) throws ServletException, IOException {
	CategoryModel category = new CategoryModel();
	DiskFileItemFactory diskFileItemFactory = new
	DiskFileItemFactory();
	ServletFileUpload servletFileUpload = new
	ServletFileUpload(diskFileItemFactory);
	servletFileUpload.setHeaderEncoding("UTF-8"); 
	try {
	resp.setContentType("text/html");
	resp.setCharacterEncoding("UTF-8");
	req.setCharacterEncoding("UTF-8");
	List<FileItem> items = servletFileUpload.parseRequest(req);
	for (FileItem item : items) {
	if (item.getFieldName().equals("name")) {
	category.setCate_name(item.getString("UTF-8"));
	} else if (item.getFieldName().equals("icon")) {
		String originalFileName = item.getName();
		int index = originalFileName.lastIndexOf(".");
		String ext = originalFileName.substring(index + 1);
		String fileName = System.currentTimeMillis() + "." + ext;
		File file = new File(Constant.DIR + "/category/" + fileName);
		item.write(file);
		category.setCate_icon("category/"+fileName);
		}}
		cateService.insert(category);
		resp.sendRedirect(req.getContextPath() + "/admin/category/list");
		} catch (FileUploadException e) {
		e.printStackTrace();
		} catch (Exception e) {
		e.printStackTrace();
		}}
	
}
