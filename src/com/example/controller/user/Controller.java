package com.example.controller.user;

import java.util.Map;

public interface Controller {
  String execute(Map<String, Object> model) throws Exception;
}
