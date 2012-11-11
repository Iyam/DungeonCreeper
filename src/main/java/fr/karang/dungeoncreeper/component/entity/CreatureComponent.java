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
package fr.karang.dungeoncreeper.component.entity;

import java.util.HashMap;
import java.util.Map;

import org.spout.api.component.components.EntityComponent;

import fr.karang.dungeoncreeper.data.DungeonData;
import fr.karang.dungeoncreeper.player.Team;
import fr.karang.dungeoncreeper.player.skill.Skill;

public abstract class CreatureComponent extends EntityComponent {

	private Map<Skill, Integer> requiredLevel = new HashMap<Skill, Integer>();
	private Map<Class<? extends Skill>, Skill> skills = new HashMap<Class<? extends Skill>, Skill>();
	
	@Override
	public void onAttached() {
		getData().put(DungeonData.HEALTH, 10);
		getData().put(DungeonData.MAX_HEALTH, 10);
		getData().put(DungeonData.DAMAGES, 0);
		getData().put(DungeonData.SKILLSLOT, 0);
		getData().put(DungeonData.LEVEL, 1);
	}

	public void addSkill(Skill skill, int level) {
		requiredLevel.put(skill, level);
		skills.put(skill.getClass(), skill);
	}
	
	public boolean hasSkill(Class<? extends Skill> skill) {
		return skills.containsKey(skill);
	}
	
	public Skill getSkill(Class<? extends Skill> skill) {
		return skills.get(skill);
	}
	
	public void setSlot(int slot){
		getData().put(DungeonData.SKILLSLOT, slot);
	}

	public void primaryInterract() {
		// TODO Auto-generated method stub
		
	}

	public void secondaryInterract() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean hasRequired(Team team){
		return true;
	}
}