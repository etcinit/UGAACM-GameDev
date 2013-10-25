package com.chromabits.ugaacm.WarpDrive.physics;

import com.chromabits.ugaacm.WarpDrive.physics.Vector2;
import com.chromabits.ugaacm.WarpDrive.physics.Boundary;
import com.chromabits.ugaacm.WarpDrive.physics.Manifold;

public class Circle implements Boundary{

  public double radius;
  public Vector2 center;
  
  public Circle(double r, Vector2 center){
    this.radius = r;
    this.center = center;
  }
  
  //check collision with a circle
  public boolean circleCollision(Circle c){
    double r = this.radius + c.radius;
    r *= r;
    return r < this.center.distance2(c.center);
  }
  
  public Manifold getCollisionManifold(Boundary B){
    //@TODO: Implement
    return null;
  }
}