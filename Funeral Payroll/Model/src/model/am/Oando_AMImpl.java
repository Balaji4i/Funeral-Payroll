package model.am;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import model.am.common.Oando_AM;

import model.ro.XxhrHmoMasterHdr_ROVOImpl;

import model.vo.XXHR_REMOTE_WORK_VOImpl;
import model.vo.XxfndAttachment_EOViewImpl;

import oracle.adf.share.ADFContext;

import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.domain.Number;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Nov 09 11:33:37 IST 2020
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class Oando_AMImpl extends ApplicationModuleImpl implements Oando_AM {
    /**
     * This is the default constructor (do not remove).
     */
    public Oando_AMImpl() {
    }
    public BigDecimal getPersonId(String userName) {
        System.out.println("UserName::::: " + userName);
        BigDecimal personId = new BigDecimal(0);
        ViewObjectImpl vo = this.getUsers_ROVO();
        ViewCriteria vc = vo.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        vcRow.setAttribute("Username", userName);
        vc.addRow(vcRow);
        vo.applyViewCriteria(vc);
        vo.executeQuery();
        if (vo.getEstimatedRowCount() > 0) {
            personId = (BigDecimal) vo.first().getAttribute("PersonId");
            System.out.println("PersonId:: " + personId);
            ADFContext.getCurrent()
                      .getSessionScope()
                      .put("personId", personId);
        }

        return personId;
    }
    public void filterUser() {
        String userName = ADFContext.getCurrent()
                                    .getSessionScope()
                                    .get("userName")
                                    .toString();
        System.err.println(userName + "--------------User Name");
        ViewObjectImpl vo = getXXSSHR_FUNERAL_SUPPORT_VO();
        vo.setNamedWhereClauseParam("b_username", userName);
        vo.executeQuery();
        System.err.println(vo.getEstimatedRowCount() + "-------Row Count");
        getPersonId(userName);
        
    //        getAssignmentType();
    }
    /**
     * Container's getter for BUPA_Option_LOV.
     * @return BUPA_Option_LOV
     */
    public ViewObjectImpl getBUPA_Option_LOV() {
        return (ViewObjectImpl) findViewObject("BUPA_Option_LOV");
    }

    /**
     * Container's getter for XxperEmployee_V_ROVO1.
     * @return XxperEmployee_V_ROVO1
     */
    public ViewObjectImpl getXxperEmployee_V_ROVO1() {
        return (ViewObjectImpl) findViewObject("XxperEmployee_V_ROVO1");
    }

    /**
     * Container's getter for SelfDependent_ROVO.
     * @return SelfDependent_ROVO
     */
    public ViewObjectImpl getSelfDependent_ROVO() {
        return (ViewObjectImpl) findViewObject("SelfDependent_ROVO");
    }



  

    /**
     * Container's getter for BUPA_Cat_LOV.
     * @return BUPA_Cat_LOV
     */
    public ViewObjectImpl getBUPA_Cat_LOV() {
        return (ViewObjectImpl) findViewObject("BUPA_Cat_LOV");
    }

    /**
     * Container's getter for TRA_Option_LOV.
     * @return TRA_Option_LOV
     */
    public ViewObjectImpl getTRA_Option_LOV() {
        return (ViewObjectImpl) findViewObject("TRA_Option_LOV");
    }

    /**
     * Container's getter for TRA_Cat_LOV.
     * @return TRA_Cat_LOV
     */
    public ViewObjectImpl getTRA_Cat_LOV() {
        return (ViewObjectImpl) findViewObject("TRA_Cat_LOV");
    }

    /**
     * Container's getter for XxhrHmoMasterHdr_ROVO.
     * @return XxhrHmoMasterHdr_ROVO
     */
    public XxhrHmoMasterHdr_ROVOImpl getXxhrHmoMasterHdr_ROVO() {
        return (XxhrHmoMasterHdr_ROVOImpl) findViewObject("XxhrHmoMasterHdr_ROVO");
    }

    /**
     * Container's getter for Title_LOV.
     * @return Title_LOV
     */
    public ViewObjectImpl getTitle_LOV() {
        return (ViewObjectImpl) findViewObject("Title_LOV");
    }

    /**
     * Container's getter for Gender_LOV.
     * @return Gender_LOV
     */
    public ViewObjectImpl getGender_LOV() {
        return (ViewObjectImpl) findViewObject("Gender_LOV");
    }


    /**
     * Container's getter for MaritalStatus_LOV.
     * @return MaritalStatus_LOV
     */
    public ViewObjectImpl getMaritalStatus_LOV() {
        return (ViewObjectImpl) findViewObject("MaritalStatus_LOV");
    }

    /**
     * Container's getter for SearchHMOTrxHdr_ROVO.
     * @return SearchHMOTrxHdr_ROVO
     */
    public ViewObjectImpl getSearchHMOTrxHdr_ROVO() {
        return (ViewObjectImpl) findViewObject("SearchHMOTrxHdr_ROVO");
    }


    /**
     * gets the current existing database connection
     * @return Connection-Object
     */
    public Connection getCurrentConnection() {
        Statement st = null;
        try {
            st = getDBTransaction().createStatement(0);
            return st.getConnection();
        } catch (Exception s) {
            s.printStackTrace();
            return null;
        } finally {
            if (st != null)
                try {
                    st.close();
                } catch (Exception s2) {
                }
        }
    }


    /**
     * Container's getter for HMOApprovalCount_ROVO1.
     * @return HMOApprovalCount_ROVO1
     */
    public ViewObjectImpl getHMOApprovalCount_ROVO() {
        return (ViewObjectImpl) findViewObject("HMOApprovalCount_ROVO");
    }

    /**
     * Container's getter for XxfndAttachment_EOView1.
     * @return XxfndAttachment_EOView1
     */
    public XxfndAttachment_EOViewImpl getXxfndAttachment_EOView() {
        return (XxfndAttachment_EOViewImpl) findViewObject("XxfndAttachment_EOView");
    }

    /**
     * Container's getter for HMOOtherRequestCount_ROVO1.
     * @return HMOOtherRequestCount_ROVO1
     */
    public ViewObjectImpl getHMOOtherRequestCount_ROVO() {
        return (ViewObjectImpl) findViewObject("HMOOtherRequestCount_ROVO");
    }

    /**
     * Container's getter for SearchHMOOtherRequests_ROVO1.
     * @return SearchHMOOtherRequests_ROVO1
     */
    public ViewObjectImpl getSearchHMOOtherRequests_ROVO() {
        return (ViewObjectImpl) findViewObject("SearchHMOOtherRequests_ROVO");
    }

    /**
     * Container's getter for XxhrHmoCard_VO1.
     * @return XxhrHmoCard_VO1
     */
    public ViewObjectImpl getHMOCard_VO() {
        return (ViewObjectImpl) findViewObject("HMOCard_VO");
    }

    /**
     * Container's getter for XxhrHmoComplaint_VO1.
     * @return XxhrHmoComplaint_VO1
     */
    public ViewObjectImpl getHMOComplaint_VO() {
        return (ViewObjectImpl) findViewObject("HMOComplaint_VO");
    }


    public String updateNewApprovedDependent(String hmo_ref_no) {
        String msg = "";
        try {
            Number hmo_ref = new Number(hmo_ref_no);
            String stmt1 = "BEGIN XXHR_HMO_PKG.UPDATE_APPROVED_NEW_DEPENDENTS(:I_HMO_NEW_ID,:O_ERROR_MSG); END;";
            CallableStatement st = null;
            st = this.getDBTransaction().createCallableStatement(stmt1, 0);
            st.setObject("I_HMO_NEW_ID", hmo_ref);
            st.registerOutParameter("O_ERROR_MSG", Types.VARCHAR);
            st.executeUpdate();
            
            if (st.getObject("O_ERROR_MSG") != null) {
                 msg = st.getObject("O_ERROR_MSG").toString();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return msg;
    }


    /**
     * Container's getter for Users_ROVO1.
     * @return Users_ROVO1
     */
    public ViewObjectImpl getUsers_ROVO() {
        return (ViewObjectImpl) findViewObject("Users_ROVO");
    }

    /**
     * Container's getter for Employee_View_ROVO1.
     * @return Employee_View_ROVO1
     */
    public ViewObjectImpl getEmployee_View_ROVO() {
        return (ViewObjectImpl) findViewObject("Employee_View_ROVO");
    }


    /**
     * Container's getter for XXHR_REMOTE_WORK_VO1.
     * @return XXHR_REMOTE_WORK_VO1
     */
    public XXHR_REMOTE_WORK_VOImpl getXXHR_REMOTE_WORK_VO1() {
        return (XXHR_REMOTE_WORK_VOImpl) findViewObject("XXHR_REMOTE_WORK_VO1");
    }


    /**
     * Container's getter for XxfndAttachment_EOView1.
     * @return XxfndAttachment_EOView1
     */
    public XxfndAttachment_EOViewImpl getXxfndAttachment_EOView1() {
        return (XxfndAttachment_EOViewImpl) findViewObject("XxfndAttachment_EOView1");
    }

    /**
     * Container's getter for Remote_Vl1.
     * @return Remote_Vl1
     */
    public ViewLinkImpl getRemote_Vl1() {
        return (ViewLinkImpl) findViewLink("Remote_Vl1");
    }

    /**
     * Container's getter for HolidayList_ROVO1.
     * @return HolidayList_ROVO1
     */
    public ViewObjectImpl getHolidayList_ROVO() {
        return (ViewObjectImpl) findViewObject("HolidayList_ROVO");
    }

    /**
     * Container's getter for XXSSHR_FUNERAL_SUPPORT_VO1.
     * @return XXSSHR_FUNERAL_SUPPORT_VO1
     */
    public ViewObjectImpl getXXSSHR_FUNERAL_SUPPORT_VO() {
        return (ViewObjectImpl) findViewObject("XXSSHR_FUNERAL_SUPPORT_VO");
    }

    /**
     * Container's getter for XxfndAttachment_EOView2.
     * @return XxfndAttachment_EOView2
     */
    public XxfndAttachment_EOViewImpl getXxfndAttachment_EOView2() {
        return (XxfndAttachment_EOViewImpl) findViewObject("XxfndAttachment_EOView2");
    }

    /**
     * Container's getter for Funeral_VL1.
     * @return Funeral_VL1
     */
    public ViewLinkImpl getFuneral_VL() {
        return (ViewLinkImpl) findViewLink("Funeral_VL");
    }
}
