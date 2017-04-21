package com.example.servlet;

import com.example.dictionary.translation.DictionaryWord;
import com.example.dictionary.translation.TranslationService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/servlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(req.getServletContext());
        TranslationService bean = context.getBean(TranslationService.class);

        String word = req.getParameter("word");
        List<DictionaryWord> words = bean.getTranslationsForWord(word);

        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        words.forEach(writer::println);
        writer.flush();

    }
}
