// 전송 계층은 네트워크에서 데이터 전송의 신뢰성을 보장하고,
// 패킷의 흐름을 제어하며, 오류 복구와 같은 기능을 수행하는 계층 (대표적인 프로토콜 tcp, udp)

// 클라이언트가 서버에 메세지 보냄 -> 서버는 메세지를 작은 청크로 분할하여 저장
// 클라이언트는 데이터 분할 및 재조립, 신뢰성 있는 전송

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransportLayerService {

  private static final int CHUNK_SIZE = 5;
  private List<String> messageChunks = new ArrayList<>();

  public void sendMessage(String message) {
    messageChunks.clear();
    int length = message.length();
    for (int i = 0; i < length; i += CHUNK_SIZE) {
      messageChunks.add(message.substring(i, Math.min(length, i + CHUNK_SIZE)));
    }
  } // 청크 단위로 분해해서 메세지 발신

  public String receiveMessage() {
    StringBuilder message = new StringBuilder();
    for (String chunk : messageChunks) {
      message.append(chunk);
    }
    return message.toString();
  } // 다시 분해된 메세지 재조립하여, 반환(수신)

  public List<String> getMessageChunks() {
    return messageChunks;
  }
}
