/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.vue;

/**
 *
 * @author ypeyrot
 */
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Serialisation {

    public Serialisation() {
    }

    public abstract void apply(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
