package com.stock.app.interfaces

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ViewController {

  @GetMapping("/view/stock")
  fun stock(): String {
    return "html/index"
  }
  
}