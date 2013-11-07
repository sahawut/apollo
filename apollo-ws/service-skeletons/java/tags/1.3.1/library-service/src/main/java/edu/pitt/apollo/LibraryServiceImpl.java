/* Copyright 2012 University of Pittsburgh
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy of
 * the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package edu.pitt.apollo;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.ConfigScope;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ext.Db4oUUID;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import edu.pitt.apollo.service.libraryservice._10._28._2013.LibraryServiceEI;
import edu.pitt.apollo.types._10._28._2013.ApolloIndexableItem;
import edu.pitt.apollo.types._10._28._2013.CuratedLibraryItem;
import edu.pitt.apollo.types._10._28._2013.CuratedLibraryItemContainer;

import java.io.File;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Map;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;

@WebService(targetNamespace = "http://service.apollo.pitt.edu/libraryservice/10/28/2013/", portName = "LibraryServiceEndpoint", serviceName = "LibraryService_v1.3.1", endpointInterface = "edu.pitt.apollo.service.libraryservice._10._28._2013.LibraryServiceEI")
class LibraryServiceImpl implements LibraryServiceEI {

    private static ObjectContainer db4o;
    private static String APOLLO_DIR = "";

    @Override
    @WebResult(name = "uuid", targetNamespace = "")
    @RequestWrapper(localName = "addLibraryItem", targetNamespace = "http://service.apollo.pitt.edu/libraryservice/10/28/2013/", className = "edu.pitt.apollo.service.libraryservice._10._28._2013.AddLibraryItem")
    @WebMethod(action = "http://service.apollo.pitt.edu/apolloservice/10/28/2013/addLibraryItem")
    @ResponseWrapper(localName = "addLibraryItemResponse", targetNamespace = "http://service.apollo.pitt.edu/libraryservice/10/28/2013/", className = "edu.pitt.apollo.service.libraryservice._10._28._2013.AddLibraryItemResponse")
    public String addLibraryItem(
            @WebParam(name = "apolloIndexableItem", targetNamespace = "") ApolloIndexableItem apolloIndexableItem,
            @WebParam(name = "itemDescription", targetNamespace = "") String itemDescription,
            @WebParam(name = "itemSource", targetNamespace = "") String itemSource,
            @WebParam(name = "itemType", targetNamespace = "") String itemType,
            @WebParam(name = "itemIndexingLabels", targetNamespace = "") List<String> itemIndexingLabels) {
        // TODO Auto-generated method stub
        String apolloUuid = "";
        db4o.store(apolloIndexableItem);
        db4o.commit();
        Db4oUUID uuid = db4o.ext().getObjectInfo(apolloIndexableItem).getUUID();

        for (int i = 0; i < uuid.getSignaturePart().length; i++) {
            apolloUuid += (char) uuid.getSignaturePart()[i];
        }
        apolloUuid += " " + uuid.getLongPart();

        // Db4oUUId u = new Db4oUUID(longPart_, signaturePart_)
        System.out.println("uuid is " + apolloUuid);

        GregorianCalendar c = new GregorianCalendar();
        XMLGregorianCalendar date;
        try {
            date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

            CuratedLibraryItem cli = new CuratedLibraryItem();
            cli.setItemCreationTime(date);
            cli.setItemDescription(itemDescription);
            cli.setItemSource(itemSource);
            cli.setItemType(itemType);
            cli.setItemUuid(apolloUuid);
            cli.getItemIndexingLabels().addAll(itemIndexingLabels);
            db4o.store(cli);
            db4o.commit();
        } catch (DatatypeConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return apolloUuid;
    }

    @Override
    @WebResult(name = "curatedLibraryItemContainer", targetNamespace = "")
    @RequestWrapper(localName = "getLibraryItem", targetNamespace = "http://service.apollo.pitt.edu/libraryservice/10/28/2013/", className = "edu.pitt.apollo.service.libraryservice._10._28._2013.GetLibraryItem")
    @WebMethod(action = "http://service.apollo.pitt.edu/apolloservice/10/28/2013/getLibraryItem")
    @ResponseWrapper(localName = "getLibraryItemResponse", targetNamespace = "http://service.apollo.pitt.edu/libraryservice/10/28/2013/", className = "edu.pitt.apollo.service.libraryservice._10._28._2013.GetLibraryItemResponse")
    public CuratedLibraryItemContainer getLibraryItem(
            @WebParam(name = "uuid", targetNamespace = "") String uuid) {
        // TODO Auto-generated method stub
        long longPart = Long.valueOf(uuid.split(" ")[1]);
        String sig = uuid.split(" ")[0];
        byte[] signaturePart = new byte[sig.length()];
        for (int i = 0; i < sig.length(); i++) {
            signaturePart[i] = (byte) sig.charAt(i);
        }
        Db4oUUID db4oUuid = new Db4oUUID(longPart, signaturePart);
        Object o = db4o.ext().getByUUID(db4oUuid);

        CuratedLibraryItemContainer result = new CuratedLibraryItemContainer();
        result.setApolloIndexableItem((ApolloIndexableItem) o);
        CuratedLibraryItem cli = new CuratedLibraryItem();
        cli.setItemUuid(uuid);
        ObjectSet<Object> r = db4o.queryByExample(cli);
        CuratedLibraryItem item = (CuratedLibraryItem) r.get(0);
        db4o.activate(item, 100);
        db4o.activate(o, 100);

        result.setCuratedLibraryItem(item);
        return result;
    }

    @Override
    @WebResult(name = "uuids", targetNamespace = "")
    @RequestWrapper(localName = "getUuidsForLibraryItemsCreatedSinceDateTime", targetNamespace = "http://service.apollo.pitt.edu/libraryservice/10/28/2013/", className = "edu.pitt.apollo.service.libraryservice._10._28._2013.GetUuidsForLibraryItemsCreatedSinceDateTime")
    @WebMethod(action = "http://service.apollo.pitt.edu/apolloservice/10/28/2013/getUuidsForLibraryItemsCreatedSinceDateTime")
    @ResponseWrapper(localName = "getUuidsForLibraryItemsCreatedSinceDateTimeResponse", targetNamespace = "http://service.apollo.pitt.edu/libraryservice/10/28/2013/", className = "edu.pitt.apollo.service.libraryservice._10._28._2013.GetUuidsForLibraryItemsCreatedSinceDateTimeResponse")
    public List<String> getUuidsForLibraryItemsCreatedSinceDateTime(
            @WebParam(name = "creationDateTime", targetNamespace = "") XMLGregorianCalendar creationDateTime) {
        // TODO Auto-generated method stub
        List<String> resultList = new ArrayList<String>();
//
        CuratedLibraryItem cli = new CuratedLibraryItem();
        final ObjectSet<CuratedLibraryItem> allItems = db4o.queryByExample(cli);

        for (CuratedLibraryItem item : allItems) {
            int c = item.getItemCreationTime().compare(creationDateTime);
            if ((c == DatatypeConstants.EQUAL)
                    || (c == DatatypeConstants.GREATER)) {
                resultList.add(item.getItemUuid());
            }
        }
        return resultList;
    }

    @Override
    @WebResult(name = "uuids", targetNamespace = "")
    @RequestWrapper(localName = "getUuidsForLibraryItemsGivenType", targetNamespace = "http://service.apollo.pitt.edu/libraryservice/10/28/2013/", className = "edu.pitt.apollo.service.libraryservice._10._28._2013.GetUuidsForLibraryItemsGivenType")
    @WebMethod(action = "http://service.apollo.pitt.edu/apolloservice/10/28/2013/getUuidsForLibraryItemsGivenType")
    @ResponseWrapper(localName = "getUuidsForLibraryItemsGivenTypeResponse", targetNamespace = "http://service.apollo.pitt.edu/libraryservice/10/28/2013/", className = "edu.pitt.apollo.service.libraryservice._10._28._2013.GetUuidsForLibraryItemsGivenTypeResponse")
    public List<String> getUuidsForLibraryItemsGivenType(
            @WebParam(name = "type", targetNamespace = "") String type) {
        // TODO Auto-generated method stub
        List<String> resultList = new ArrayList<String>();
//
        CuratedLibraryItem cli = new CuratedLibraryItem();
        final ObjectSet<CuratedLibraryItem> allItems = db4o.queryByExample(cli);

        for (CuratedLibraryItem item : allItems) {
            if (item.getItemType().equals(type)) {
                resultList.add(item.getItemUuid());
            }
        }
        return resultList;
    }

    static {
        Map<String, String> env = System.getenv();
        APOLLO_DIR = env.get("APOLLO_131_WORK_DIR");
        if (APOLLO_DIR != null) {
            if (!APOLLO_DIR.endsWith(File.separator)) {
                APOLLO_DIR += File.separator;
            }
            System.out.println("APOLLO_DIR is now:" + APOLLO_DIR);
        } else {
            System.out.println("APOLLO_131_WORK_DIR environment variable not found!");
            APOLLO_DIR = "";
        }
        EmbeddedConfiguration configuration = Db4oEmbedded.newConfiguration();
        configuration.file().generateUUIDs(ConfigScope.GLOBALLY);
        db4o = Db4oEmbedded.openFile(configuration, APOLLO_DIR + "/db4o_db_131");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        db4o.close();
    }
}