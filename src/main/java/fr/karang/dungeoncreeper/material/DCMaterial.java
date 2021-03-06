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

import org.spout.api.geo.cuboid.Block;
import org.spout.api.material.BlockMaterial;
import org.spout.api.material.Material;

import fr.karang.dungeoncreeper.DungeonCreeper;
import fr.karang.dungeoncreeper.player.Team;
import fr.karang.dungeoncreeper.player.Team.TeamColor;
import fr.karang.dungeoncreeper.world.DungeonGame;

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
	
	public final DungeonGame getGame(Block block){
		return DungeonCreeper.getInstance().getLobby().getGame(block.getWorld());
	}
	
	public final TeamColor getOwner(Block block){
		DungeonGame game = getGame(block);
		return game.getTerritory(block.getX(), block.getZ());
	}
	
	public boolean isClaimedBy(Block block, Team team){
		return getOwner(block) == team.getColor();
	}

	public boolean isClaimedBlockByOtherTeam(Block block, Team team){
		TeamColor owner = getOwner(block);
		if(owner == null)
			return false;
		return owner != team.getColor();
	}

	public boolean isNextClaimedBlock(Block block, Team team){
		if(isClaimedBy(block.getWorld().getBlock(block.getX() + 1, block.getY(), block.getZ()), team))
			return true;
		if(isClaimedBy(block.getWorld().getBlock(block.getX() - 1, block.getY(), block.getZ()), team))
			return true;
		if(isClaimedBy(block.getWorld().getBlock(block.getX(), block.getY(), block.getZ() + 1), team))
			return true;
		if(isClaimedBy(block.getWorld().getBlock(block.getX(), block.getY(), block.getZ() - 1), team))
			return true;
		return true;
	}
	
}
