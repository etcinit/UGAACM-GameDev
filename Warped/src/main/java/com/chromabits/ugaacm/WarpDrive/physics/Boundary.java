package com.chromabits.ugaacm.WarpDrive.physics;

public interface Boundary{
  //Get manifold containing information on Boundary collision
  public Manifold getCollisionManifold(Boundary B);
}