package au.com.realestate.entity;

import lombok.Data;

@Data
public class Context {
  private Coordinates boundary;
  private Position position;
}
