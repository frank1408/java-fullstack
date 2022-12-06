package rodriguez.api.controllers;

import rodriguez.api.dao.UsuarioDao;
import rodriguez.api.models.Usuario;
import rodriguez.api.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    /* CON ACCESO A BASE DE DATOS */
    @RequestMapping( value = "api/login", method = RequestMethod.POST  )
    public String login( @RequestBody Usuario infoUser ) {

        String token = "";
        try {
            Usuario usuariOK = usuarioDao.obtenerUsuarioPorCredenciales(infoUser);
            token = jwtUtil.create(
                String.valueOf(usuariOK.getId()),
                usuariOK.getCorreo()
            );
        }catch(Exception e) {
            token = "-1";
            System.err.println( e.toString() );
        }
        return token;

    } /* login */
    /* CON ACCESO A BASE DE DATOS */

} // public class AuthController
