package com.example.controller.main;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
  String process(HttpServletRequest req, HttpServletResponse res) throws Exception;
}
