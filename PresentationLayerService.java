// 표현 계층은 데이터 형식의 변환, 암호화, 압축 등을 담당
// 데이터를 json 형태로 직렬화/역직렬화하고, 데이터를 암호화/복호화하는 기능

// 직렬화 :  객체나 데이터 구조를 연속된 바이트 스트림으로 변환하는 과정
// {"name":"John","age":30}
// 역직렬화 : 직렬화된 바이트 스트림을 원래의 객체나 데이터 구조로 변환하는 과정
// John, 30

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PresentationLayerService {

  private final ObjectMapper objectMapper;
  private final PasswordEncoder passwordEncoder;

  public PresentationLayerService() {
    this.objectMapper = new ObjectMapper();
    this.passwordEncoder = new BCryptPasswordEncoder();
  }

  public String serializeToJson(Object data) throws JsonProcessingException {
    return objectMapper.writeValueAsString(data);
  }

  public <T> T deserializeFromJson(String json, Class<T> valueType) throws JsonProcessingException {
    return objectMapper.readValue(json, valueType);
  }

  public String encrypt(String rawData) {
    return passwordEncoder.encode(rawData);
  }

  public boolean verify(String rawData, String encodedData) {
    return passwordEncoder.matches(rawData, encodedData);
  }
}
