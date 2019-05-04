package j2c.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LangHelper {

    public static String langFromCookie(HttpServletRequest req, HttpServletResponse res, String lang) {

        if (lang == null) {
            Cookie[] ckArr = req.getCookies();
            if (ckArr != null && ckArr.length > 0) {
                for (Cookie ck : ckArr) {
                    if ("lang".equals(ck.getName())) {
                        String localLang = ckArr[0].getValue();
                        return localLang;
                    }
                }

            } else {
                appendLangInCookie(res, "en");
                return "en";
            }
        } else {
            Cookie[] ckArr = req.getCookies();
            if (ckArr != null && ckArr.length > 0) {
                for (Cookie ck : ckArr) {
                    if ("lang".equals(ck.getName())) {
                        String localLang = ckArr[0].getValue();
                        if(localLang.equals(lang))
                            return lang;
                        else{
                            appendLangInCookie(res, lang);
                            return lang;
                        }
                    }
                }

            } else {
                appendLangInCookie(res, lang);
                return lang;
            }
        }
        return "en";
    }


    public static void appendLangInCookie(HttpServletResponse res, String lang) {
        Cookie ck = new Cookie("lang", lang);
        res.addCookie(ck);
    }



}
