package camp.nextstep.controller;

import camp.nextstep.domain.User;
import camp.nextstep.dao.InMemoryUserDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.interface21.webmvc.servlet.mvc.asis.Controller;

public class RegisterController implements Controller {

    @Override
    public String execute(final HttpServletRequest req, final HttpServletResponse res) throws Exception {
        final var user = new User(2,
                req.getParameter("account"),
                req.getParameter("password"),
                req.getParameter("email"));
        InMemoryUserDao.save(user);

        return "redirect:/index.jsp";
    }
}
