package login;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieMemidGet {

	public static String getCookie(HttpServletRequest request, String name) throws UnsupportedEncodingException {
        String result = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                	String res = cookie.getValue();
                    result = URLDecoder.decode(res, "utf-8");
                    break;
                }
            }
        }

        return result;

	}

	public static void setCookie(HttpServletRequest request, HttpServletResponse response, String path, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setPath(path);
        //httpsで稼働している環境であればCookieが暗号化されるようSecure属性をつける
        if ("https".equals(request.getScheme())) {
            cookie.setSecure(true);
        }
        response.addCookie(cookie);
    }
}
