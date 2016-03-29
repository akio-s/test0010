package jp.co.token.DBaccess;

import jp.co.token.base.*;

public class WICDataAccess {
    private static final String MY_CLASS_NAME = "WICDataAccess";

    public WICTable invoke(String methodName, WICTable table)
                                  throws WICSystemException, WICUserException {
        final String MY_METHOD_NAME = "invoke";

        WICTable result = null;
        try {
            if ("checkLogin".equals(methodName)) {
                result = getUserInfo(table);
            } else if ("checkDeputyLogin".equals(methodName)) {
                result = getDeputyUserInfo(table);

            } else if ("searchAddress".equals(methodName)) {
                result = searchAddress(table);

            } else if ("getSendingTable".equals(methodName)) {
                result = getSendingTable(table);

            } else if ("getIncomeEarner".equals(methodName)) {
                result = getIncomeEarner(table);
            } else if ("updateInEarFromHonnin1".equals(methodName)) {
                result = updateInEarFromHonnin1(table);
            } else if ("updateInEarFromSpouse".equals(methodName)) {
                result = updateInEarFromSpouse(table);
            } else if ("updateInEarFromDependent".equals(methodName)) {
                result = updateInEarFromDependent(table);
            } else if ("updateInEarFromHonnin2".equals(methodName)) {
                result = updateInEarFromHonnin2(table);
            } else if ("updateInEarFromOthers".equals(methodName)) {
                result = updateInEarFromOthers(table);
            } else if ("updateInEarFromLife".equals(methodName)) {
                result = updateInEarFromLife(table);
            } else if ("updateInEarFromIndemnity".equals(methodName)) {
                result = updateInEarFromIndemnity(table);
            } else if ("updateInEarFromSocial".equals(methodName)) {
                result = updateInEarFromSocial(table);
            } else if ("updateInEarFromEnterprise".equals(methodName)) {
                result = updateInEarFromEnterprise(table);
            } else if ("updateInEarFromHouseLoan".equals(methodName)) {
                result = updateInEarFromHouseLoan(table);
            } else if ("updateInEarFromHouseLoan2".equals(methodName)) {
                   result = updateInEarFromHouseLoan2(table);
            } else if ("updateInEarFromComplete".equals(methodName)) {
                result = updateInEarFromComplete(table);
            } else if ("updateInEarFinalRelease".equals(methodName)) {
                result = updateInEarFinalRelease(table);
            } else if ("updateInEarBeforeWork".equals(methodName)) {
                result = updateInEarBeforeWork(table);
            } else if ("getDependent".equals(methodName)) {
                result = getDependent(table);
            } else if ("getAllDependent".equals(methodName)) {
                result = getAllDependent(table);
            } else if ("entryDependent".equals(methodName)) {
                result = entryDependent(table);
            } else if ("removeDependent".equals(methodName)) {
                result = removeDependent(table);
            } else if ("getAllInsurance".equals(methodName)) {
                result = getAllInsurance(table);
            } else if ("getInsurance".equals(methodName)) {
                result = getInsurance(table);
            } else if ("entryInsurance".equals(methodName)) {
                result = entryInsurance(table);
            } else if ("removeInsurance".equals(methodName)) {
                result = removeInsurance(table);
            } else if ("getWithholdingSummarize".equals(methodName)) {
                result = getWithholdingSummarize(table);
            } else if ("getWithholdingReference".equals(methodName)) {
                result = getWithholdingReference(table);
            } else if ("getWithholdingZai".equals(methodName)) {
                result = getWithholdingZai(table);
            } else if ("getWithholdingTai".equals(methodName)) {
                result = getWithholdingTai(table);
            } else if ("getWithholdingSendding".equals(methodName)) {
                result = getWithholdingSendding(table);
            } else if ("getPaymentRecord".equals(methodName)) {
                result = getPaymentRecord(table);
            } else if ("getRelationship".equals(methodName)) {
                result = getRelationship();
            } else if ("getControlData".equals(methodName)) {
                result = getControlData(table);
            } else {
                throw new WICSystemException(MY_CLASS_NAME, MY_METHOD_NAME, 10,
                                              "NOT FOUND invoke" + methodName);
            }
        } catch (WICUserException ue) {
            throw ue;
        } catch (WICSystemException se) {
            throw se;
        }
        return result;
    }

    private WICTable getUserInfo(WICTable data)
                                  throws WICSystemException, WICUserException {
        final String MY_METHOD_NAME = "getUserInfo";

        WICTable userInfo = null;
        try {
            String searchKey1 = data.getValue("CPSUSID", 0);
            String searchKey2 = data.getValue("CPSPSW2", 0);
            WIDUserInfo dbaController = new WIDUserInfo();
            userInfo = dbaController.getUserInfo(searchKey1, searchKey2);

        } catch (WICSystemException se) {
            throw se;
        } catch (WICUserException ue) {
            throw ue;
        }
        return userInfo;
    }

    private WICTable getDeputyUserInfo(WICTable data)
                                  throws WICSystemException, WICUserException {
        final String MY_METHOD_NAME = "getDeputyUserInfo";

        WICTable userInfo = null;
        try {
            String searchKey1 = data.getValue("CPSUSID", 0);
            WIDUserInfo dbaController = new WIDUserInfo();
            userInfo = dbaController.getDeputyUserInfo(searchKey1);

        } catch (WICSystemException se) {
            throw se;
        } catch (WICUserException ue) {
            throw ue;
        }
        return userInfo;
    }

    private WICTable searchAddress(WICTable data)
                                  throws WICSystemException, WICUserException {
        final String MY_METHOD_NAME = "searchAddress";

        WICTable addressList = null;
        try {
            String searchKey = data.getValue("POSTCODE", 0);
            WIDAddress dbaController = new WIDAddress();
            addressList = dbaController.searchAddress(searchKey);

        } catch (WICSystemException se) {
            throw se;
        } catch (WICUserException ue) {
            throw ue;
        }
        return addressList;
    }

    private WICTable getSendingTable(WICTable data)
                                  throws WICSystemException  {
        final String MY_METHOD_NAME = "getSendingTable";

        WICTable sendingList = null;
        try {
            String searchKey1 = data.getValue("PNSBMC1", 0);
            int searchKey2 = Integer.parseInt(data.getValue("PNSNEND", 0));
            WIDSendingTable dbaController = new WIDSendingTable();
            sendingList = dbaController.getSendingTable(searchKey1, searchKey2);
        } catch (WICSystemException se) {
            throw se;
        } catch (Exception e) {
            throw new WICSystemException(MY_CLASS_NAME, MY_METHOD_NAME,
                                          10, e.toString());
        }
        return sendingList;
    }

    private WICTable getIncomeEarner(WICTable data) throws WICSystemException {
        final String MY_METHOD_NAME = "getIncomeEarner";

        WICTable incomeEarner = null;
        try {
            int searchKey1 = Integer.parseInt(data.getValue("PNSNEND", 0));
            String searchKey2 = data.getValue("PNSSYCD", 0);

            WIDIncomeEarner dbaController = new WIDIncomeEarner();
            incomeEarner = dbaController.getIncomeEarner(searchKey1, searchKey2);

        } catch (WICSystemException se) {
            throw se;
        } catch (Exception e) {
            throw new WICSystemException(MY_CLASS_NAME, MY_METHOD_NAME,
                                          10, e.toString());
        }
        return incomeEarner;
    }

    private WICTable getJigyosyoSyain(WICTable data) throws WICSystemException {
        final String MY_METHOD_NAME = "getJigyosyoSyain";

        WICTable incomeEarner = null;
        try {
            String searchKey1 = data.getValue("PNSBMC1", 0);
            int searchKey2 = Integer.parseInt(data.getValue("PNSNEND", 0));
            WIDIncomeEarner dbaController = new WIDIncomeEarner();
            incomeEarner = dbaController.getJigyosyoSyain(searchKey1, searchKey2);

        } catch (WICSystemException se) {
            throw se;
        } catch (Exception e) {
            throw new WICSystemException(MY_CLASS_NAME, MY_METHOD_NAME,
                                          10, e.toString());
        }
        return incomeEarner;
    }

    private WICTable updateInEarFromHonnin1(WICTable data)
                                                    throws WICSystemException {
        final String MY_METHOD_NAME = "updateInEarFromHonnin1";

        WICTable incomeEarner = null;
        try {
            WIDIncomeEarner dbaController = new WIDIncomeEarner();
            dbaController.updateForHonnin1(data);

        } catch (WICSystemException se) {
            throw se;
        } catch (Exception e) {
            throw new WICSystemException(MY_CLASS_NAME, MY_METHOD_NAME,
                                          10, e.toString());
        }
        return incomeEarner;
    }

    private WICTable updateInEarFromSpouse(WICTable data)
                                                    throws WICSystemException {
        final String MY_METHOD_NAME = "updateInEarFromSpouse";

        WICTable incomeEarner = null;
        try {
            WIDIncomeEarner dbaController = new WIDIncomeEarner();
            dbaController.updateInEarFromSpouse(data);

        } catch (WICSystemException se) {
            throw se;
        } catch (Exception e) {
            throw new WICSystemException(MY_CLASS_NAME, MY_METHOD_NAME,
                                          10, e.toString());
        }
        return incomeEarner;
    }

    private WICTable updateInEarFromDependent(WICTable data)
                                                    throws WICSystemException {
        final String MY_METHOD_NAME = "updateInEarFromDependent";

        WICTable incomeEarner = null;
        try {
            WIDIncomeEarner dbaController = new WIDIncomeEarner();
            dbaController.updateInEarFromDependent(data);

        } catch (WICSystemException se) {
            throw se;
        } catch (Exception e) {
            throw new WICSystemException(MY_CLASS_NAME, MY_METHOD_NAME,
                                          10, e.toString());
        }
        return incomeEarner;
    }

    private WICTable updateInEarFromHonnin2(WICTable data)
                                                    throws WICSystemException {
        final String MY_METHOD_NAME = "updateInEarFromHonnin2";

        WICTable incomeEarner = null;
        try {
            WIDIncomeEarner dbaController = new WIDIncomeEarner();
            dbaController.updateForHonnin2(data);

        } catch (WICSystemException se) {
            throw se;
        } catch (Exception e) {
            throw new WICSystemException(MY_CLASS_NAME, MY_METHOD_NAME,
                                          10, e.toString());
        }
        return incomeEarner;
    }

    private WICTable updateInEarFromOthers(WICTable data)
                                                    throws WICSystemException {
        final String MY_METHOD_NAME = "updateInEarFromOthers";

        WICTable incomeEarner = null;
        try {
            WIDIncomeEarner dbaController = new WIDIncomeEarner();
            dbaController.updateInEarFromOthers(data);

        } catch (WICSystemException se) {
            throw se;
        } catch (Exception e) {
            throw new WICSystemException(MY_CLASS_NAME, MY_METHOD_NAME,
                                          10, e.toString());
        }
        return incomeEarner;
    }

    private WICTable updateInEarFromLife(WICTable data)
                                                    throws WICSystemException {
        final String MY_METHOD_NAME = "updateInEarFromLife";

        WICTable incomeEarner = null;
        try {
            WIDIncomeEarner dbaController = new WIDIncomeEarner();
            dbaController.updateInEarFromLife(data);

        } catch (WICSystemException se) {
            throw se;
        } catch (Exception e) {
            throw new WICSystemException(MY_CLASS_NAME, MY_METHOD_NAME,
                                          10, e.toString());
        }
        return incomeEarner;
    }

    private WICTable updateInEarFromIndemnity(WICTable data)
                                                    throws WICSystemException {
        final String MY_METHOD_NAME = "updateInEarFromIndemnity";

        WICTable incomeEarner = null;
        try {
            WIDIncomeEarner dbaController = new WIDIncomeEarner();
            dbaController.updateInEarFromIndemnity(data);

        } catch (WICSystemException se) {
            throw se;
        } catch (Exception e) {
            throw new WICSystemException(MY_CLASS_NAME, MY_METHOD_NAME,
                                          10, e.toString());
        }
        return incomeEarner;
   }

    private WICTable updateInEarFromSocial(WICTable data)
                                                    throws WICSystemException {
        final String MY_METHOD_NAME = "updateInEarFromSocial";

        WICTable incomeEarner = null;
        try {
            WIDIncomeEarner dbaController = new WIDIncomeEarner();
            dbaController.updateInEarFromSocial(data);

        } catch (WICSystemException se) {
            throw se;
        } catch (Exception e) {
            throw new WICSystemException(MY_CLASS_NAME, MY_METHOD_NAME,
                                                              10, e.toString());
        }
        return incomeEarner;
    }

    private WICTable updateInEarFromEnterprise(WICTable data)
                                                    throws WICSystemException {
        final String MY_METHOD_NAME = "updateInEarFromEnterprise";

        WICTable incomeEarner = null;
        try {
            WIDIncomeEarner dbaController = new WIDIncomeEarner();
            dbaController.updateInEarFromEnterprise(data);

        } catch (WICSystemException se) {
            throw se;
        } catch (Exception e) {
            throw new WICSystemException(MY_CLASS_NAME, MY_METHOD_NAME,
                                          10, e.toString());
        }
        return incomeEarner;
    }

    private WICTable updateInEarFromHouseLoan(WICTable data)
                                                    throws WICSystemException {
        final String MY_METHOD_NAME = "updateInEarFromHouseLoan";

        WICTable incomeEarner = null;
        try {
            WIDIncomeEarner dbaController = new WIDIncomeEarner();
            dbaController.updateInEarFromHouseLoan(data);
            if (data.getValue("PNSJKKB", 0).equals("0")) {
            	dbaController.deleteHouseSubtraction(data);
            } else if (dbaController.isHouseSubtraction(data)) {
            	dbaController.updateHouseSubtraction(data);
            }else{
            	dbaController.insertHouseSubtraction(data);
            }
        } catch (WICSystemException se) {
            throw se;
        } catch (Exception e) {
            throw new WICSystemException(MY_CLASS_NAME, MY_METHOD_NAME,
                                          10, e.toString());
        }
        return incomeEarner;
    }

    private WICTable updateInEarFromHouseLoan2(WICTable data)
                                                    throws WICSystemException {
        final String MY_METHOD_NAME = "updateInEarFromHouseLoan2";

        WICTable incomeEarner = null;
        try {
            WIDIncomeEarner dbaController = new WIDIncomeEarner();
            dbaController.updateInEarFromHouseLoan(data);
            if (data.getValue("PNSJKKB", 0).equals("0")) {
            	dbaController.deleteHouseSubtraction(data);
            } else if (dbaController.isHouseSubtraction(data)) {
            	dbaController.updateHouseSubtraction2(data);
            }else{
            	dbaController.insertHouseSubtraction2(data);
            }
        } catch (WICSystemException se) {
            throw se;
        } catch (Exception e) {
            throw new WICSystemException(MY_CLASS_NAME, MY_METHOD_NAME,
                                          10, e.toString());
        }
        return incomeEarner;
    }
    private WICTable updateInEarFromComplete(WICTable data)
                                                    throws WICSystemException {
        final String MY_METHOD_NAME = "updateInEarFromComplete";

        WICTable incomeEarner = null;
        try {
            WIDIncomeEarner dbaController = new WIDIncomeEarner();
            dbaController.updateInEarFromComplete(data);

        } catch (WICSystemException se) {
            throw se;
        } catch (Exception e) {
            throw new WICSystemException(MY_CLASS_NAME, MY_METHOD_NAME,
                                          10, e.toString());
        }
        return incomeEarner;
    }

    private WICTable updateInEarFinalRelease(WICTable data)
                                                    throws WICSystemException {
        final String MY_METHOD_NAME = "updateInEarFinalRelease";

        WICTable incomeEarner = null;
        try {
            WIDIncomeEarner dbaController = new WIDIncomeEarner();
            dbaController.updateInEarFinalRelease(data);

        } catch (WICSystemException se) {
            throw se;
        } catch (Exception e) {
            throw new WICSystemException(MY_CLASS_NAME, MY_METHOD_NAME,
                                          10, e.toString());
        }
        return incomeEarner;
    }

    private WICTable updateInEarBeforeWork(WICTable data)
                                                    throws WICSystemException {
        final String MY_METHOD_NAME = "updateInEarBeforeWork";

        WICTable incomeEarner = null;
        try {
            WIDIncomeEarner dbaController = new WIDIncomeEarner();
            dbaController.updateInEarBeforeWork(data);

        } catch (WICSystemException se) {
            throw se;
        } catch (Exception e) {
            throw new WICSystemException(MY_CLASS_NAME, MY_METHOD_NAME,
                                          10, e.toString());
        }
        return incomeEarner;
    }

    private WICTable getDependent(WICTable data) throws WICSystemException {
        final String MY_METHOD_NAME = "getDependent";

        WICTable dependent = null;
        try {
            int searchKey1 = Integer.parseInt(data.getValue("PNFNEND", 0));
            String searchKey2 = data.getValue("PNFSYCD", 0);
            String searchKey3 = data.getValue("PNFFYKB", 0);
            WIDDependent dbaController = new WIDDependent();
            dependent = dbaController.getDependent(searchKey1,
                                                    searchKey2, searchKey3);

        } catch (WICSystemException se) {
            throw se;
        }
        return dependent;
    }

    private WICTable getAllDependent(WICTable data) throws WICSystemException {
        final String MY_METHOD_NAME = "getAllDependent";

        WICTable dependent = null;
        try {
            int searchKey1 = Integer.parseInt(data.getValue("PNFNEND", 0));
            String searchKey2 = data.getValue("PNFSYCD", 0);
            WIDDependent dbaController = new WIDDependent();
            dependent = dbaController.getAllDependent(searchKey1, searchKey2);
        } catch (WICSystemException se) {
            throw se;
        }
        return dependent;
    }

    private WICTable entryDependent(WICTable data) throws WICSystemException {
        final String MY_METHOD_NAME = "entryDependent";

        WICTable dependent = null;
        try {
            WIDDependent dbaController = new WIDDependent();
            dbaController.entryDependent(data);

        } catch (WICSystemException se) {
            throw se;
        }
        return dependent;
    }

    private WICTable removeDependent(WICTable data) throws WICSystemException {
        final String MY_METHOD_NAME = "removeDependent";

        WICTable dependent = null;
        try {
            int searchKey1 = Integer.parseInt(data.getValue("PNFNEND", 0));
            String searchKey2 = data.getValue("PNFSYCD", 0);
            String searchKey3 = data.getValue("PNFFYKB", 0);
            WIDDependent dbaController = new WIDDependent();
            dbaController.removeDependent(searchKey1, searchKey2, searchKey3);

        } catch (WICSystemException se) {
            throw se;
        }
        return dependent;
    }

    private WICTable getAllInsurance(WICTable data) throws WICSystemException {
        final String MY_METHOD_NAME = "getAllInsurance";

        WICTable insurance = null;
        try {
            int searchKey1 = Integer.parseInt(data.getValue("PNHNEND", 0));
            String searchKey2 = data.getValue("PNHSYCD", 0);
            WIDInsurance dbaController = new WIDInsurance();
            insurance = dbaController.getAllInsurance(searchKey1, searchKey2);

        } catch (WICSystemException se) {
            throw se;
        }
        return insurance;
    }

    private WICTable getInsurance(WICTable data) throws WICSystemException {
        final String MY_METHOD_NAME = "getInsurance";

        WICTable insurance = null;
        try {
            int searchKey1 = Integer.parseInt(data.getValue("PNHNEND", 0));
            String searchKey2 = data.getValue("PNHSYCD", 0);
            String searchKey3 = data.getValue("PNHHSKB", 0);
            WIDInsurance dbaController = new WIDInsurance();
            insurance = dbaController.getInsurance(searchKey1,
                                                    searchKey2, searchKey3);

        } catch (WICSystemException se) {
            throw se;
        }
        return insurance;
    }

    private WICTable entryInsurance(WICTable data) throws WICSystemException {
        final String MY_METHOD_NAME = "entryInsurance";

        WICTable insurance = null;
        try {
            WIDInsurance dbaController = new WIDInsurance();
            dbaController.entryInsurance(data);

        } catch (WICSystemException se) {
            throw se;
        }
        return insurance;
    }

    private WICTable removeInsurance(WICTable data) throws WICSystemException {
        final String MY_METHOD_NAME = "removeInsurance";

        WICTable insurance = null;
        try {
            WIDInsurance dbaController = new WIDInsurance();
            dbaController.removeInsurance(data);

        } catch (WICSystemException se) {
            throw se;
        }
        return insurance;
    }

    private WICTable getBeforeJob(WICTable data) throws WICSystemException {
        final String MY_METHOD_NAME = "getBeforeJob";

        WICTable beforeJob = null;
        try {
            int searchKey1 = Integer.parseInt(data.getValue("PNZNEND", 0));
            String searchKey2 = data.getValue("PNZSYCD", 0);
            WIDBeforeJob dbaController = new WIDBeforeJob();
            beforeJob = dbaController.getBeforeJob(searchKey1, searchKey2);

        } catch (WICSystemException se) {
            throw se;
        }
        return beforeJob;
    }

    private WICTable entryBeforeJob(WICTable data) throws WICSystemException {
        final String MY_METHOD_NAME = "entryBeforeJob";

        WICTable beforeJob = null;
        try {
            WIDBeforeJob dbaController = new WIDBeforeJob();
            dbaController.entryBeforeJob(data);

        } catch (WICSystemException se) {
            throw se;
        }
        return beforeJob;
    }

    private WICTable removeBeforeJob(WICTable data) throws WICSystemException {
        final String MY_METHOD_NAME = "removeBeforeJob";

        WICTable beforeJob = null;
        try {
            int searchKey1 = Integer.parseInt(data.getValue("PNZNEND", 0));
            String searchKey2 = data.getValue("PNZSYCD", 0);
            WIDBeforeJob dbaController = new WIDBeforeJob();
            dbaController.removeBeforeJob(searchKey1, searchKey2);

        } catch (WICSystemException se) {
            throw se;
        }
        return beforeJob;
    }

    private WICTable getWithholdingReference(WICTable data) throws WICSystemException {
        final String MY_METHOD_NAME = "getWithholdingReference";

        WICTable withholding = null;
        try {
            int searchKey1 = Integer.parseInt(data.getValue("PNGNEND", 0));
            String searchKey2 = data.getValue("PNGSYCD", 0);
            WIDWithholding dbaController = new WIDWithholding();
            withholding = dbaController.getWithholdingReference(searchKey1, searchKey2);
        } catch (WICSystemException se) {
            throw se;
        }
        return withholding;
    }

    private WICTable getWithholdingZai(WICTable data) throws WICSystemException {
        final String MY_METHOD_NAME = "getWithholdingZai";

        WICTable withholding = null;
        try {
            int searchKey1 = Integer.parseInt(data.getValue("PNGNEND", 0));
            String searchKey2 = data.getValue("PNGBMC1", 0);
            String searchKey3 = data.getValue("NENCHOYEAR", 0);
            String searchKey4 = data.getValue("PNGJGCD", 0);
            WIDWithholding dbaController = new WIDWithholding();
          withholding = dbaController.getWithholdingZai(searchKey1, searchKey2, searchKey3, searchKey4);
        } catch (WICSystemException se) {
            throw se;
        }
        return withholding;
    }

    private WICTable getWithholdingTai(WICTable data) throws WICSystemException {
        final String MY_METHOD_NAME = "getWithholdingTai";

        WICTable withholding = null;
        try {
            int searchKey1 = Integer.parseInt(data.getValue("PNGNEND", 0));
            String searchKey2 = data.getValue("NENCHOYEAR", 0);
            String searchKey3 = data.getValue("PNGJGCD", 0);
            WIDWithholding dbaController = new WIDWithholding();
            withholding = dbaController.getWithholdingTai(searchKey1, searchKey2, searchKey3);
        } catch (WICSystemException se) {
            throw se;
        }
        return withholding;
    }

    private WICTable getWithholdingSendding(WICTable data) throws WICSystemException {
        final String MY_METHOD_NAME = "getWithholdingSendding";

        WICTable withholding = null;
        try {
            int searchKey1 = Integer.parseInt(data.getValue("PNGNEND", 0));
            String searchKey2 = data.getValue("PNGBMC1", 0);
            String searchKey3 = data.getValue("NENCHOYEAR", 0);
            String searchKey4 = data.getValue("PNGJGCD", 0);
            WIDWithholding dbaController = new WIDWithholding();
          withholding = dbaController.getWithholdingSendding(searchKey1, searchKey2, searchKey3, searchKey4);
        } catch (WICSystemException se) {
            throw se;
        }
        return withholding;
    }

    private WICTable getWithholdingSummarize(WICTable data) throws WICSystemException {
        final String MY_METHOD_NAME = "getWithholdingSummarize";

        WICTable withholding = null;
        try {
            int searchKey1 = Integer.parseInt(data.getValue("YEAR", 0));
            String searchKey2 = data.getValue("FROMJ", 0);
            String searchKey3 = data.getValue("TOJ", 0);
            String searchKey4 = data.getValue("JGCD", 0);
            String searchKey5 = data.getValue("SHCD", 0);
            WIDWithholding dbaController = new WIDWithholding();
            withholding = dbaController.getWithholdingSummarize(searchKey1, searchKey2, searchKey3, searchKey4, searchKey5);
        } catch (WICSystemException se) {
            throw se;
        }
        return withholding;
    }

    private WICTable getPaymentRecord(WICTable data) throws WICSystemException {
        final String MY_METHOD_NAME = "getPaymentRecord";

        WICTable paymentRecord = null;
        try {
            int searchKey1 = Integer.parseInt(data.getValue("PNENEND", 0));
            String searchKey2 = data.getValue("PNESYCD", 0);
            WIDPaymentRecord dbaController = new WIDPaymentRecord();
            paymentRecord = dbaController.getPaymentRecord(searchKey1,
                                                            searchKey2);

        } catch (WICSystemException se) {
            throw se;
        }
        return paymentRecord;
    }

    private WICTable getRelationship() throws WICSystemException {
        final String MY_METHOD_NAME = "getRelationship";
        WICTable relationship = null;
        try {
            WIDRelationship dbaController = new WIDRelationship();
            relationship = dbaController.getRelationship();

        } catch (WICSystemException se) {
            throw se;
        }
        return relationship;
    }

    private WICTable getControlData(WICTable searchKey) throws WICSystemException {
        final String MY_METHOD_NAME = "getRelationship";
        WICTable control = null;
        try {
        	String key = searchKey.getValue("KNCKEY", 0);
            WIDControl dbaController = new WIDControl();
            control = dbaController.getControl(key);
        } catch (WICSystemException se) {
            throw se;
        }
        return control;
    }
}
