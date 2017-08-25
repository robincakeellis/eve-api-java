package com.tlabs.eve.esi;

import com.tlabs.eve.esi.model.ESIAsset;
import com.tlabs.eve.esi.model.ESICalendar;
import com.tlabs.eve.esi.model.ESICharacter;
import com.tlabs.eve.esi.model.ESICharacterStatus;
import com.tlabs.eve.esi.model.ESIFitting;
import com.tlabs.eve.esi.model.ESIFleet;
import com.tlabs.eve.esi.model.ESIKillMail;
import com.tlabs.eve.esi.model.ESILocation;
import com.tlabs.eve.esi.model.ESIMail;
import com.tlabs.eve.esi.model.ESIMailbox;
import com.tlabs.eve.esi.model.ESIMarketHistory;
import com.tlabs.eve.esi.model.ESIMarketItem;
import com.tlabs.eve.esi.model.ESIMarketOrder;
import com.tlabs.eve.esi.model.ESIName;
import com.tlabs.eve.esi.model.ESIServerStatus;
import com.tlabs.eve.esi.model.ESIShip;

import java.util.List;
import java.util.Map;

public interface ESIService {

    ESIServerStatus getServerStatus();

    List<ESIMarketItem> getMarketPrices();

    List<ESIMarketOrder> getMarketOrders(final Long regionID, final Long itemID);

    List<ESIMarketHistory> getMarketHistory(final Long regionID, final Long itemID);

    List<ESIName> getRegions();

    ESILocation.Region getRegion(final Long id);

    ESILocation.Constellation getConstellation(final Long id);

    ESILocation.SolarSystem getSolarSystem(final Long id);

    ESILocation.Station getStation(final Long id);

    List<Long> listStructures();

    ESILocation.Structure getStructure(Long id);

    Map<Long, ESILocation.SolarSystem> getSolarSystemStatistics();

    List<ESIName> getNames(final List<Integer> ids);

    ESIKillMail getKillMail(final ESIKillMail killMail);

    ESICharacterStatus getCharacterStatus();

    ESICharacter getCharacter();

    ESILocation getCharacterLocation();

    ESIShip getCharacterShip();

    ESICalendar getCalendar(final Long afterEventID);

    //Disappeared from ESI
    //boolean postCalendarEvent(Long eventID, ESICalendar.Event.Response response);
    List<ESIAsset> getAssets();

    boolean deleteMail(final Long mailID);

    List<ESIMail> getMails(final Long afterMailID, final String... labels);

    List<ESIMailbox> getMailboxes();

    ESIMail getMailContent(final Long mailID);

    Integer postMail(final ESIMail mail);

    boolean updateMail(final ESIMail mail);

    boolean createMailbox(final ESIMailbox mailbox);

    List<ESIKillMail> getKillMails(Integer maxCount, Long maxKillID, boolean withContent);

    List<ESIFitting> getFittings();

    Long postFitting(final ESIFitting fitting);

    boolean deleteFitting(final Long fittingID);

    boolean deleteFleetMember(long fleetId, long memberId);

    boolean deleteFleetSquad(long fleetId, long squadId);

    boolean deleteFleetWing(long fleetId, long wingId);

    ESIFleet getFleet(long fleetId);

    List<ESIFleet.Member> getFleetMembers(long fleetId);

    List<ESIFleet.Wing> getFleetWings(long fleetId);

    boolean postFleetInvitation(long fleetId, ESIFleet.Member member);

    Long postFleetWing(long fleetId);

    Long postFleetSquad(long fleetId, long wingId);

    boolean updateFleet(ESIFleet fleet);

    boolean updateFleetMember(long fleetId, ESIFleet.Member member);

    boolean updateFleetSquad(long fleetId, long squadId, String name);

    boolean updateFleetWing(long fleetId, long wingId, String name);

}
