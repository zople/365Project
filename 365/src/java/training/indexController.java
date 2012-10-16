/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author wangxiu
 */
@Named(value = "indexController")
@SessionScoped
public class indexController implements Serializable {

    /**
     * Creates a new instance of indexController
     */
    public indexController() {
    }
}
