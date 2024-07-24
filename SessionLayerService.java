// 세션은 클라이언트와 서버 간의 지속적인 상호 작용을 유지
// 사용자가 웹 애플리케이션과 상호 작용하는 동안 상태를 유지하는 데 사용


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
@Service
public class SessionLayerService {
  public void login(HttpSession session, String username) {
    session.setAttribute("username", username);
  } // login

  public String checkSession(HttpSession session) {
    String username = (String) session.getAttribute("username");
    if (username == null) {
      return "No user is logged in.";
    } else {
      return "Logged in as " + username;
    }
  } // user_name으로 login 여부 확인

  public void logout(HttpSession session) {
    session.invalidate();
  } // logout
}
