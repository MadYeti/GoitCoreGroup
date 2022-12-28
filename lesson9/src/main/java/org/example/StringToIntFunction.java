package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.Function;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class StringToIntFunction implements Function<String, Integer> {

  private String number;

  @Override
  public Integer apply(String number) {
    return Integer.parseInt(number);
  }

}
