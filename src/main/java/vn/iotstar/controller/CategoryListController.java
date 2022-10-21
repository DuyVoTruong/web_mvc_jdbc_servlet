package vn.iotstar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.model.CategoryModel;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = { "/admin/category/list" })
public class CategoryListController extends HttpServlet{
	//private CategoryService cateService;
	CategoryService cateService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse
	resp) throws ServletException, IOException {
	List<CategoryModel> cateList = cateService.getALLCategory();
	req.setAttribute("cateList", cateList);
	RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/listCate.jsp");
	dispatcher.forward(req, resp);
	}
}
