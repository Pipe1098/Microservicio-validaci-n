package com.example.Validador;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;
import java.util.regex.Pattern;

@Service
    public class ValidationService {
        public ValidationService(){}
//COMMENT v

        private final static String EMAIL_REGEX = "[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        private final static LocalDate MIN_FECHA_NACIMIENTO = LocalDate.of(1980, 1, 1);
        private final static Set<String> JOB_TITLES_VALIDOS = Set.of(
                "Haematologist", "Phytotherapist", "Building surveyor",
                "Insurance account manager", "Educational psychologist"

        );

        private boolean validarEmail(String email) {
            boolean x= email.matches(EMAIL_REGEX);
            return x;
        }

        private boolean validarFechaNacimiento(String fechaNacimiento) {
            LocalDate fechaNac = LocalDate.parse(fechaNacimiento);
            return fechaNac.isAfter(MIN_FECHA_NACIMIENTO);
        }

        private boolean validarJobTitle(String jobTitle) {
            return JOB_TITLES_VALIDOS.contains(jobTitle);
        }
        public boolean validarLinea(Person persona) {

            boolean esValido = true;
            if (!validarEmail(persona.getEmail())) {
                return false; // El email no es válido
            }
            if (!validarFechaNacimiento(persona.getDateBirth())) {
                return false; // La fecha de nacimiento no es válida
            }
            if (!validarJobTitle(persona.getJobTitle())) {
                return false; // El título del trabajo no es válido
            }
            return esValido;


        }

       /* public static void main(String[] args) {
            ValidationService validationService = new ValidationService();
           // String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
            //Regular Expression
           // String regx = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
           // String emailx="jperez@gmail.com";
           // boolean validarEmail= emailx.matches(regx);
           // System.out.println(validarEmail);
            //Compile regular expression to get the pattern
           // Pattern pattern = Pattern.compile(regx);
            Person persona1 = new Person("Juan", "Perez", "jperez", "1985-01-01", "jperez@gmail.com","+1-114-355-1841x78347", "1990-06-28", "Phytotherapist");
            Person persona2 = new Person("Maria", "Gonzalez", "mgonzalez@@gmail.com", "1990-02-15", "Dentist","","2","none");

            boolean resultado1 = validationService.validarLinea(persona1);
            boolean resultado2 = validationService.validarLinea(persona2);

            System.out.println("Persona 1 es válida: " + resultado1);
            System.out.println("Persona 2 es válida: " + resultado2);
        }*/
    }
