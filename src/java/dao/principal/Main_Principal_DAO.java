/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.principal;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import managedbean.principal.Curso_MB;

/**
 *
 * @author diego
 */
public class Main_Principal_DAO {

    private static List<Curso_MB> cursos = new ArrayList();

    static {
        cursos.add(new Curso_MB(1, "Curso 1", "Matematicas", "A"));
        cursos.add(new Curso_MB(2, "Curso 2", "Español", "I"));
        cursos.add(new Curso_MB(3, "Curso 3", "Historia", "A"));
        cursos.add(new Curso_MB(4, "Curso 4", "Ciencias", "I"));
    }

    public static List<Curso_MB> getCursos() {
        return cursos;
    }

    public static List<Curso_MB> getData(Enumeration elemts) {
        List<Curso_MB> data = new ArrayList();
        while (elemts.hasMoreElements()) {
            String parameter = (String) elemts.nextElement();
            data.add(cursos.get(Integer.parseInt(parameter) - 1));
        }
        return data;
    }

}
