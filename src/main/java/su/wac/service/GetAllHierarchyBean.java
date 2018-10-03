package su.wac.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.wac.model.business.*;
import su.wac.model.jpa.AllHierarchy;

import java.util.ArrayList;

@Service
public class GetAllHierarchyBean {

    private SessionFactory sessionFactory;

    @Autowired
    public  void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory =sessionFactory;
    }

    @Transactional
    public Htree getTree() {
        Htree allHierarchyTree = new Htree();
        Session session = this.sessionFactory.getCurrentSession();
        try {
            ArrayList<AllHierarchy> allHierarchies = (ArrayList<AllHierarchy>) session
                    .createStoredProcedureQuery("transport", "AllHierarchyMapping")
                    .getResultList();
            System.out.println("========AllHierarchy=========");

            ManagementNode root = new ManagementNode(allHierarchies.get(0).getBmId(),
                    HierarchyType.MANAGEMENT,
                    allHierarchies.get(0).getBmManager(),
                    allHierarchies.get(0).getBmAddress());
            allHierarchyTree.setRootElement(root);
            for (AllHierarchy ah3: allHierarchies) {
                if (ah3.getPathLabel().equals("bm") & ah3.getBmId() > 1){
                    root.addChild(new ManagementNode(ah3.getBmId(),
                            HierarchyType.MANAGEMENT,
                            ah3.getBmManager(),ah3.getBmAddress()));
                }
                else if (ah3.getHierarchy().split("\\.").length ==2) {
                    if (ah3.getPathLabel().equals("pc")) {
                        root.addChild(new PassengerCarNode(ah3.getPcId(),
                                HierarchyType.PASSENGER_CAR,
                                ah3.getPcTankAverage(),
                                ah3.getPcDriver(),
                                ah3.getPcRegistrationPlate()));
                    }
                    else if (ah3.getPathLabel().equals("bs")) {
                        root.addChild(new BusNode(ah3.getBsId(),
                                HierarchyType.BUS,
                                ah3.getBsTankAverage(),
                                ah3.getBsCapacity(),
                                ah3.getBsDriver(),
                                ah3.getBsRegistrationPlate()));
                    }
                    else if (ah3.getPathLabel().equals("tr")) {
                        root.addChild(new TruckNode(ah3.getTrId(),
                                HierarchyType.TRUCK,
                                ah3.getTrTankAverage(),
                                ah3.getTrCargo(),
                                ah3.getTrDriver(),
                                ah3.getTrRegistrationPlate()));
                    }
                }
                else if (ah3.getHierarchy().split("\\.").length == 3) {
                    if (ah3.getHierarchy().split("\\.")[1].substring(2,3).equals("2")) {
                        if (ah3.getPathLabel().equals("pc")) {
                            root.getChildren().get(0).addChild(new PassengerCarNode(ah3.getPcId(),
                                    HierarchyType.PASSENGER_CAR,
                                    ah3.getPcTankAverage(),
                                    ah3.getPcDriver(),
                                    ah3.getPcRegistrationPlate()));
                        }
                        else if (ah3.getPathLabel().equals("bs")) {
                            root.getChildren().get(0).addChild(new BusNode(ah3.getBsId(),
                                    HierarchyType.BUS,
                                    ah3.getBsTankAverage(),
                                    ah3.getBsCapacity(),
                                    ah3.getBsDriver(),
                                    ah3.getBsRegistrationPlate()));
                        }
                        else if (ah3.getPathLabel().equals("tr")) {
                            root.getChildren().get(0).addChild(new TruckNode(ah3.getTrId(),
                                    HierarchyType.TRUCK,
                                    ah3.getTrTankAverage(),
                                    ah3.getTrCargo(),
                                    ah3.getTrDriver(),
                                    ah3.getTrRegistrationPlate()));
                        }
                    }
                    else if (ah3.getHierarchy().split("\\.")[1].substring(2,3).equals("3")) {
                        if (ah3.getPathLabel().equals("pc")) {
                            root.getChildren().get(1).addChild(new PassengerCarNode(ah3.getPcId(),
                                    HierarchyType.PASSENGER_CAR,
                                    ah3.getPcTankAverage(),
                                    ah3.getPcDriver(),
                                    ah3.getPcRegistrationPlate()));
                        }
                        else if (ah3.getPathLabel().equals("bs")) {
                            root.getChildren().get(1).addChild(new BusNode(ah3.getBsId(),
                                    HierarchyType.BUS,
                                    ah3.getBsTankAverage(),
                                    ah3.getBsCapacity(),
                                    ah3.getBsDriver(),
                                    ah3.getBsRegistrationPlate()));
                        }
                        else if (ah3.getPathLabel().equals("tr")) {
                            root.getChildren().get(1).addChild(new TruckNode(ah3.getTrId(),
                                    HierarchyType.TRUCK,
                                    ah3.getTrTankAverage(),
                                    ah3.getTrCargo(),
                                    ah3.getTrDriver(),
                                    ah3.getTrRegistrationPlate()));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("========AllHierarchyDone=========");
        return allHierarchyTree;
    }

}