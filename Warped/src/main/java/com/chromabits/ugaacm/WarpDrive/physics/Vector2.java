package com.chromabits.ugaacm.WarpDrive.physics;

import java.lang.Math;


public class Vector2{
  public double x;
  public double y;
  
  //obvious constructors
  public Vector2(){
    y = x = 0;
  }
  
  public Vector2(double x, double y){
    this.x = x;
    this.y = y;
  }
  
  //magnitude and magnitude^2 (for performance)
  public double magnitude(){
    return Math.sqrt(magnitude2());
  }
  
  public double magnitude2(){
    return x*x + y*y;
  }
  
  //add a vector to this one
  public void add(Vector2 v){
    this.x += v.x;
    this.y += v.y;
  }
  
  //scalar multiply
  public void smult(double f){
    this.x *= f;
    this.y *= f;
  }
  
  //dot product
  public double dot(Vector2 v){
    return this.x * v.x + this.y * v.y;
  }
  
  //distance, distance^2 (for performance)
  public double distance(Vector2 v){
    return Math.sqrt(distance2(v));
  }
  
  public double distance2(Vector2 v){
    Vector2 temp = new Vector2(v.x - this.x, v.y - this.y);
    return temp.magnitude2();
  }
  
  //unit vector in the direction of this
  public Vector2 unit(){
    Vector2 newVec = this;
    newVec.smult(1 / this.magnitude());
    return newVec;
  }
}
