package com.chromabits.ugaacm.WarpDrive.physics;
import com.chromabits.ugaacm.WarpDrive.physics.Vector2;

public class AABB{
  public Vector2 min;
  public Vector2 max;
  
  public AABB(Vector2 min, Vector2 max){
    this.min = min;
    this.max = max;
  }
  
  public AABB(double x1, 
              double y1, 
              double x2, 
              double y2){
    min = new Vector2(x1, y1);
    max = new Vector2(x2, y2);
  }
  
  //check collision with another AABB
  public boolean AABBcollision(AABB box){
    if (this.max.x < box.min.x || this.min.x > box.max.x) return false;
    if (this.max.y < box.min.y || this.min.y > box.max.y) return false;
    
    return true;
  }
  
  
}