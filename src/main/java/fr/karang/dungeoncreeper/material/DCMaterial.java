/*
 * This file is part of DungeonCreeper.
 *
 * Copyright (c) 2012-2012, ${project.organization.name} <${url}/>
 * DungeonCreeper is licensed under the SpoutDev License Version 1.
 *
 * DungeonCreeper is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * DungeonCreeper is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package fr.karang.dungeoncreeper.material;

import org.spout.api.material.BlockMaterial;
import org.spout.api.material.Material;

import fr.karang.dungeoncreeper.player.Team;
import fr.karang.dungeoncreeper.player.Team.TeamColor;

public abstract class DCMaterial extends BlockMaterial {

	public DCMaterial(String name, String model) {
		super((short)0, name, model);
	}
	
	public DCMaterial(short dataMask, String name, String model) {
		super(dataMask, name, model);
	}
	
	public DCMaterial(String name, int data, Material parent, String model) {
		super(name, data, parent, model);
	}

	public boolean isClaimable(){
		return false;
	}
	
	public TeamColor getOwner(){
		if(isClaimable()){
			return Team.TeamColor.values()[getData()];
		}
		return null;
	}
	
}
