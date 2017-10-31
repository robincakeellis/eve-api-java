package com.tlabs.eve.api.character;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tlabs.eve.api.EveAPI;
import com.tlabs.eve.api.corporation.CorporationRole;
import com.tlabs.eve.api.corporation.CorporationTitle;

public final class CharacterSheet implements Serializable {

	private static final long serialVersionUID = 4592061680814130573L;

    public static final class JumpClone {

        private long cloneID;
        private long locationID;

        private String name;
        private String location;//not in XML
        private final List<Implant> implants = new ArrayList<>(10);

        public void addImplant(final Implant p) {
            this.implants.add(p);
        }

        public List<Implant> getImplants() {
            return implants;
        }

        public long getCloneID() {
            return cloneID;
        }

        public void setCloneID(long cloneID) {
            this.cloneID = cloneID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getLocationID() {
            return locationID;
        }

        public void setLocationID(long locationID) {
            this.locationID = locationID;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }

    public static final class Implant {

        private long typeID;
        private String typeName;

        private String description;//Not in XML

        public long getTypeID() {
            return typeID;
        }

        public void setTypeID(long typeID) {
            this.typeID = typeID;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    private long characterID;
    private String characterName;
    private long birthdate;

    private long corporationID;
    private String corporationName;

    private long allianceID;
    private String allianceName;

    private long factionID;
    private String factionName;

    private long homeStationID;

    private double balance;

    private long cloneJumpDate;//since Phoebe

    private String gender;
    private String bloodLine;
    private String ancestry;
    private String race;

    private List<CharacterSkill> skills;
    private Map<Long, CharacterSkill> skillsMap;//skills per ID
    private long skillPoints = 0; //computed
    private long freeSkillPoints;//since Phoebe
	private long cloneSkillPoints;

    private long lastRespecDate;
    private long lastTimedRespec;
    private int freeRespecs;

    private int intelligence;
    private int charisma;
    private int willpower;
    private int perception;
    private int memory;

    private long jumpActivation;
    private long jumpFatigue;
    private long jumpLastUpdate;

    //something on Phoebe about moving clones.
    private long remoteStationDate;

    private List<CorporationRole> corporationRoles;
    private List<CorporationTitle> corporationTitles;
    private List<Long> certificates;//ids


    private List<JumpClone> jumpClones;
    private List<Implant> implants;

    public CharacterSheet() {
        super();
        this.skills = new ArrayList<>();
        this.skillsMap = new HashMap<>();
        this.corporationRoles = new ArrayList<>();
        this.corporationTitles = new ArrayList<>();
        this.certificates = new ArrayList<>();
        this.jumpClones = new ArrayList<>();
        this.implants = new ArrayList<>();
    }

    public long getSkillPoints() {
        return skillPoints;
    }

    public void addSkill(CharacterSkill skill) {
        this.skills.add(skill);
        this.skillsMap.put(skill.getSkillID(), skill);
        this.skillPoints = this.skillPoints + skill.getSkillPoints();
    }

    public CharacterSkill getSkill(long skillID) {
        return this.skillsMap.get(skillID);
    }

    public int getSkillLevel(long skillID) {
        CharacterSkill skill = this.skillsMap.get(skillID);
        return (null == skill) ? 0 : skill.getSkillLevel();
    }

    public long getSkillPoints(long skillID) {
        CharacterSkill skill = this.skillsMap.get(skillID);
        return (null == skill) ? 0l : skill.getSkillPoints();
    }

    public List<CharacterSkill> getSkills() {
        return this.skills;
    }

    public List<CorporationRole> getRoles() {
        return corporationRoles;
    }

    public void addRole(CorporationRole r) {
        this.corporationRoles.add(r);
    }

    public List<CorporationTitle> getTitles() {
        return corporationTitles;
    }

    public void addTitle(CorporationTitle t) {
        this.corporationTitles.add(t);
    }

    public List<Long> getCertificates() {
        return this.certificates;
    }

    public void addCertificate(long c) {
        this.certificates.add(c);
    }

    public long getCharacterID() {
        return characterID;
    }

    public void setCharacterID(long characterID) {
        this.characterID = characterID;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public long getCorporationID() {
        return corporationID;
    }

    public void setCorporationID(long corporationID) {
        this.corporationID = corporationID;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }

    public long getAllianceID() {
        return allianceID;
    }

    public void setAllianceID(long allianceID) {
        this.allianceID = allianceID;
    }

    public String getAllianceName() {
        return allianceName;
    }

    public void setAllianceName(String allianceName) {
        this.allianceName = allianceName;
    }

    public long getFactionID() {
        return factionID;
    }

    public void setFactionID(long factionID) {
        this.factionID = factionID;
    }

    public String getFactionName() {
        return factionName;
    }

    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }

    public long getHomeStationID() {
        return homeStationID;
    }

    public void setHomeStationID(long homeStationID) {
        this.homeStationID = homeStationID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodLine() {
        return bloodLine;
    }

    public void setBloodLine(String bloodLine) {
        this.bloodLine = bloodLine;
    }

    public final String getAncestry() {
        return ancestry;
    }

    public final void setAncestry(String ancestry) {
        this.ancestry = ancestry;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = Integer.parseInt(intelligence);
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public void setCharisma(String charisma) {
        this.charisma = Integer.parseInt(charisma);
    }

    public int getWillpower() {
        return willpower;
    }

    public void setWillpower(int willpower) {
        this.willpower = willpower;
    }

    public void setWillpower(String willpower) {
        this.willpower = Integer.parseInt(willpower);
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public void setPerception(String perception) {
        this.perception = Integer.parseInt(perception);
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setMemory(String memory) {
        this.memory = Integer.parseInt(memory);
    }

    public final long getBirthdate() {
        return birthdate;
    }

    public final void setBirthdate(long birthdate) {
        this.birthdate = birthdate;
    }

    public final void setBirthdate(String birthdate) {
        this.birthdate = EveAPI.parseDateTime(birthdate);
    }

    public long getCloneJumpDate() {
        return cloneJumpDate;
    }

    public void setCloneJumpDate(long cloneJumpDate) {
        this.cloneJumpDate = cloneJumpDate;
    }

    public void setCloneJumpDate(String cloneJumpDate) {
        this.cloneJumpDate = EveAPI.parseDateTime(cloneJumpDate);
    }

    public long getFreeSkillPoints() {
        return freeSkillPoints;
    }

    public void setFreeSkillPoints(long freeSkillPoints) {
        this.freeSkillPoints = freeSkillPoints;
    }

    public long getLastRespecDate() {
        return lastRespecDate;
    }

    public void setLastRespecDate(long lastRespecDate) {
        this.lastRespecDate = lastRespecDate;
    }

    public void setLastRespecDate(String lastRespecDate) {
        this.lastRespecDate = EveAPI.parseDateTime(lastRespecDate);
    }

    public long getLastTimedRespec() {
        return lastTimedRespec;
    }

    public void setLastTimedRespec(long lastTimedRespec) {
        this.lastTimedRespec = lastTimedRespec;
    }

    public void setLastTimedRespec(String lastTimedRespec) {
        this.lastTimedRespec = EveAPI.parseDateTime(lastTimedRespec);
    }

    public int getFreeRespecs() {
        return freeRespecs;
    }

    public void setFreeRespecs(int freeRespecs) {
        this.freeRespecs = freeRespecs;
    }

    public void addImplant(final Implant implant) {
        this.implants.add(implant);
    }

    public List<Implant> getImplants() {
        return this.implants;
    }

    public long getJumpActivation() {
        return jumpActivation;
    }

    public void setJumpActivation(long jumpActivation) {
        this.jumpActivation = jumpActivation;
    }

    public void setJumpActivation(String jumpActivation) {
        this.jumpActivation = EveAPI.parseDateTime(jumpActivation);
    }

    public long getJumpFatigue() {
        return jumpFatigue;
    }

    public void setJumpFatigue(long jumpFatigue) {
        this.jumpFatigue = jumpFatigue;
    }

    public void setJumpFatigue(String jumpFatigue) {
        this.jumpFatigue = EveAPI.parseDateTime(jumpFatigue);
    }

    public long getJumpLastUpdate() {
        return jumpLastUpdate;
    }

    public void setJumpLastUpdate(long jumpLastUpdate) {
        this.jumpLastUpdate = jumpLastUpdate;
    }

    public void setJumpLastUpdate(String jumpLastUpdate) {
        this.jumpLastUpdate = EveAPI.parseDateTime(jumpLastUpdate);
    }

    public long getRemoteStationDate() {
        return remoteStationDate;
    }

    public void setRemoteStationDate(long remoteStationDate) {
        this.remoteStationDate = remoteStationDate;
    }

    public void setRemoteStationDate(String remoteStationDate) {
        this.remoteStationDate = EveAPI.parseDateTime(remoteStationDate);
    }

    public List<JumpClone> getJumpClones() {
        return this.jumpClones;
    }

    public void addJumpClone(final JumpClone c) {
        this.jumpClones.add(c);
    }

    public void addJumpCloneImplant(final long jumpCloneID, final Implant implant) {
        for (JumpClone c: this.jumpClones) {
            if (c.getCloneID() == jumpCloneID) {
                c.addImplant(implant);
                return;
            }
        }
    }

    public long getCloneSkillPoints() {
        return cloneSkillPoints;
    }

    public void setCloneSkillPoints(long cloneSkillPoints) {
        this.cloneSkillPoints = cloneSkillPoints;
    }

}
