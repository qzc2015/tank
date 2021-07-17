package com.qzc.cor;

import com.qzc.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * @author qzc
 * @create 2021-07-17 10:07
 */
public class ColliderChain implements Collider{
	private List<Collider> colliders=new LinkedList<>();
	public ColliderChain(){
		add(new BulletTankCollider());
		add(new TankTankCollider());
	}

	public void add(Collider c){
		colliders.add(c);
	}

	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		for (int i = 0; i < colliders.size(); i++) {
			if(!colliders.get(i).collide(o1,o2)){
				return false;
			}
		}
		return true;
	}
}