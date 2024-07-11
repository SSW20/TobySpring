package tobyspring.hellospring.exRate;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Map;

//레코드
//값을 넣어주면 수정 불가능
@JsonIgnoreProperties(ignoreUnknown = true)
public record ExRateData(String result, Map<String, BigDecimal> rates) {
}
