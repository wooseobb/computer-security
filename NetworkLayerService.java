// 데이터를 목적지까지 라우팅하고 ip주소를 사용하여, 경로를 설정하는 것
// 라우팅 = 데이터 패킷이 네트워크를 통해 목적지까지 전달되는 경로를 결정하는 과정
// 목적지 = 데이터 패킷이 전달되어야 하는 최종 위치
// 라우팅 테이블 = 라우터가 데이터 패킷을 목적지까지 전달하는 데 사용하는 경로 정보를 저장하는 테이블


import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class NetworkLayerService {

  private Map<String, String> routingTable;

  public NetworkLayerService() {
    routingTable = new HashMap<>();
    // 라우팅 테이블 초기화 (예: IP 주소와 목적지 매핑)
    routingTable.put("192.168.1.1", "Server A");
    routingTable.put("192.168.1.2", "Server B");
    routingTable.put("10.0.0.1", "Server C");
    // ip 주소와 목적지 서버를 매핑한 테이블,
    // 사용자가 입력한 ip 주소를 통해 데이터 패킷의 목적지를 결정
  }

  public String routePacket(String ipAddress) {
    return routingTable.getOrDefault(ipAddress, "Unknown Destination");
  }  // 입력된 ip 주소를 기반으로 라우팅 테이블에서 목적지(서버)를 찾아 반환
}
