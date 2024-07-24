// 흐름 제어
// 데이터 전송
// 데이터 링크 : 데이터를 프레임으로 구성하고, 해당 프레임을 통해 데이터 전송을 관리
import org.springframework.stereotype.Service;

@Service
public class DataLinkLayerService {

  // 입력된 데이터 문자열을 특정 형식의 프레임으로 변환
    public String createFrame(String data) {
    return String.format("%10d%s", data.length(), data);
  }

  //  프레임으로부터 원본 데이터를 추출
    public String extractData(String frame) {
    int dataLength = Integer.parseInt(frame.substring(0, 10).trim());
    //프레임의 첫 10자리는 데이터 길이 정보를 나타내며, 그 뒤에 실제 데이터가 위치
    return frame.substring(10, 10 + dataLength);
  }
}