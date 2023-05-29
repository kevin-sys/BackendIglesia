package com.example.Backend.controller;

import com.example.Backend.dao.MiembroService;
import com.example.Backend.model.Miembro;
import com.example.Backend.dao.EmailService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/miembros"})
public class MiembroController {

    private final MiembroService miembroService;
    private final EmailService emailService;

    @Autowired
    public MiembroController(MiembroService miembroService, EmailService emailService) {
        this.miembroService = miembroService;
        this.emailService = emailService;
    }

    @GetMapping
    public List<Miembro> Listar() {
        return miembroService.listar();
    }

    @PostMapping
    public Miembro Agregar(@RequestBody Miembro m) {
        String to = m.getcorreo();
        String nombremiembro = m.getnombre() + " " + m.getapellido();
        String numeroid = m.getidentificacion();
        try {

            String subject = "Bienvenido a GodChurch";
            String message = "Querido/a \n" + nombremiembro + " identificado con el número: " + numeroid
                    + "\n"
                    + "¡Nos complace darte la bienvenida a GodChurch! Somos una comunidad cristiana comprometida en crecer juntos en nuestra fe y en experimentar el amor y la gracia de Dios.\n"
                    + "\n"
                    + "Estamos emocionados de que te hayas unido a nuestra familia de creyentes y queremos apoyarte en tu caminar espiritual. En GodChurch, encontrarás un lugar donde podrás adorar, aprender de la Palabra de Dios y conectarte con otros hermanos y hermanas en la fe.\n"
                    + "\n"
                    + "Nuestro objetivo es que encuentres un ambiente cálido y acogedor en el que puedas experimentar la presencia de Dios y ser fortalecido/a en tu relación con Él. Estamos comprometidos en brindarte enseñanzas bíblicas sólidas, oportunidades de servicio y espacios de comunión para que crezcas en tu fe y puedas impactar a otros con el amor de Cristo.\n"
                    + "\n"
                    + "Te invitamos a participar en nuestras actividades y eventos, así como en nuestros servicios de adoración semanales. Además, si tienes alguna pregunta, inquietud o necesitas apoyo en algún aspecto de tu vida espiritual, no dudes en comunicarte con nosotros. Estamos aquí para ti.\n"
                    + "\n"
                    + "Que la paz y la gracia de nuestro Señor Jesucristo te acompañen en tu camino con Él. Esperamos verte pronto en nuestros servicios y eventos.\n"
                    + "\n"
                    + "Bendiciones,\n"
                    + "\n"
                    + "Kevin Gómez Cantillo\n"
                    + "GodChurch";
            emailService.sendEmail(to, subject, message);
            System.out.println(emailService);
            Miembro miembro;
            if (0 == 0) {
                miembro = miembroService.add(m);
                return miembro;
            } else {
                System.out.println("No se pudo enviar el correo de bienvenida. Por favor, intenta nuevamente más tarde.");
            }

            return miembro;
        } catch (Exception e) {
            String adminEmail = "ksinasignargomez@unicesar.edu.co";
            String adminSubject = "ERROR AL REGISTRAR NUEVO MIEMBRO";
            String adminMessage = "Se produjo un error al registrar a: " + nombremiembro + " El correo proporcionado fue: " + to;
            emailService.sendEmail(adminEmail, adminSubject, adminMessage);
            return null;
        }

    }

    @GetMapping(path = {"/{identificacion}"})
    public Miembro listarId(@PathVariable("identificacion") String identificacion) {
        return miembroService.listarId(identificacion);
    }

    @PutMapping(path = {"/{identificacion}"})
    public Miembro editar(@RequestBody Miembro m, @PathVariable("identificacion") String identificacion) {
        m.setId(identificacion);
        return miembroService.edit(m);
    }

    @DeleteMapping(path = {"/{identificacion}"})
    public Miembro delete(@PathVariable("identificacion") String identificacion) {
        return miembroService.delete(identificacion);
    }
}
