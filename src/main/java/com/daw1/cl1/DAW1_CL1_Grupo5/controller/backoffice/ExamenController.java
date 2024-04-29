package com.daw1.cl1.DAW1_CL1_Grupo5.controller.backoffice;

import com.daw1.cl1.DAW1_CL1_Grupo5.model.db.Ejercicio1;
import com.daw1.cl1.DAW1_CL1_Grupo5.model.db.Ejercicio2;
import com.daw1.cl1.DAW1_CL1_Grupo5.model.db.Ejercicio3;
import com.daw1.cl1.DAW1_CL1_Grupo5.model.db.Ejercicio4;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExamenController {

    @GetMapping("/principal")
    public String principal() {

        return "backoffice/principal";
    }

    /**EJERCICIO 1**/

    @GetMapping("/ejercicio1")
    public String ejercicio1(Model model) {
        model.addAttribute("ejercicio1", new Ejercicio1());
        return "backoffice/ejercicio1/ejercicio1";
    }

    @PostMapping("/ejercicio1")
    public String ejercicio1(@ModelAttribute Ejercicio1 ejercicio1, Model model) {
        double precio = ejercicio1.getPreUnitario();
        int cantidad = ejercicio1.getCantUnitario();
        double total;
        if(cantidad > 20) {
            total = (precio * cantidad) * 0.90;
        }else
            if (cantidad <= 20 & cantidad >= 10) {
            total = (precio * cantidad) * 0.95;
        }else{
                total = precio * cantidad;
            }
        model.addAttribute("ejercicio1", new Ejercicio1());
            model.addAttribute("total", String.valueOf(total));
        return "backoffice/ejercicio1/ejercicio1";
    }

    /**EJERCICIO 2**/
    @GetMapping("/ejercicio2")
    public String ejercicio2(Model model) {
        model.addAttribute("ejercicio2", new Ejercicio2());
        return "backoffice/ejercicio2/ejercicio2";
    }

    @PostMapping("/ejercicio2")
    public String ejercicio2(@ModelAttribute Ejercicio2 ejercicio2, Model model) {
        int anio = ejercicio2.getAnio();
        String rs = "";
        if(anio%4 == 0) {
            rs = "Año Bisiesto";
        }else {
            rs = "Año No Bisiesto";
        }
        model.addAttribute("anio", rs);
        model.addAttribute("ejercicio2", new Ejercicio2());
        return "backoffice/ejercicio2/ejercicio2";
    }

    /**EJERCICIO 3**/

    @GetMapping("/ejercicio3")
    public String ejercicio3(Model model) {
        model.addAttribute("ejercicio3", new Ejercicio3());
        return "backoffice/ejercicio3/ejercicio3";
    }

    @PostMapping("/ejercicio3")
    public String ejercicio3(@ModelAttribute Ejercicio3 ejercicio3, Model model) {
        int n1 = ejercicio3.getN1();
        int n2 = ejercicio3.getN2();
        int n3 = ejercicio3.getN3();
        int promedio = (n1 + n2 + n3) / 3;
        String rs = "";
        if(promedio >= 70) {
            rs = "Alumno Aprobado";
        }else {
            rs = "Alumno Desaprobado";
        }
        model.addAttribute("rs", rs);
        model.addAttribute("ejercicio3", new Ejercicio3());
        return "backoffice/ejercicio3/ejercicio3";
    }

    /**EJERCICIO 4**/
    @GetMapping("/ejercicio4")
    public String ejercicio4(Model model) {
        model.addAttribute("ejercicio4", new Ejercicio4());
        return "backoffice/ejercicio4/ejercicio4";
    }

    @PostMapping("/ejercicio4")
    public String ejercicio4(@ModelAttribute Ejercicio4 ejercicio4, Model model) {
        int rs = ejercicio4.getNumero();
        String mensaje = "";
        for(int i = 1; i<=rs; i++){
            int sumDivisor = 0;
            for(int r = 1; r<i; r++) {
                if(i%r == 0) {
                    sumDivisor += r;
                }
            }
            if(sumDivisor == i) {
                mensaje = "Numero Perfecto";
            }else {
                mensaje = "Numero No Perfecto";
            }
        }
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("ejercicio4", new Ejercicio4());
        return "backoffice/ejercicio4/ejercicio4";
    }
}
