/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Konversi.Suhu.KelasC.Praktikum.Suhu.C;


import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Dimas
 */
@Controller
public class ProjectController {

    private int suhukelvin(int suhucelcius){
        int suhukelvin = (int) (suhucelcius + 273.15);
        return suhukelvin;
    }
	
	private int suhufahrenheit(int suhucelcius){
        int suhufahrenheit = (suhucelcius*9/5)+32;
        return suhufahrenheit;
    }
	
	private int suhureamur(int suhucelcius){
        int suhureamur = suhucelcius *4/5;
        return suhureamur;
    }
    @RequestMapping("/Konversi")
    //@ResponseBody
    public String getHasil(HttpServletRequest data, Model datas){
       String getnamesuhu = data.getParameter("namesuhu");
       int getsuhucelcius = Integer.parseInt(data.getParameter("suhucelcius")); 
      
       int suhureamur = suhureamur(getsuhucelcius);
       int suhukelvin = suhukelvin(getsuhucelcius);
       int suhufahrenheit = suhufahrenheit(getsuhucelcius);
       
       datas.addAttribute("suhukelvin", suhukelvin);
       datas.addAttribute("suhufahrenheit", suhufahrenheit);
       datas.addAttribute("suhucelcius", getsuhucelcius);
       datas.addAttribute("suhureamur", suhureamur);
       
       
       return "viewer";
    }
}
