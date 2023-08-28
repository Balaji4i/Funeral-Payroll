package com.view.beans;

import com.view.approval.ApprovalPayload;
import com.view.approval.ApprovalProcess;
import com.view.uiutils.ADFUtils;

import javax.faces.event.ActionEvent;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

public class SearchFuneral {
    private RichOutputText messageBind;
    private RichPopup myPopup;

    public SearchFuneral() {
        super();
    }

    public void onClickEdit(ActionEvent actionEvent) {
        Object obj =  ADFContext.getCurrent().getPageFlowScope().get("headerId");
          System.err.println("Object Name"+obj);
                 ViewObject HdrVO = com.view.utils.ADFUtils.findIterator("XXSSHR_FUNERAL_SUPPORT_VOIterator").getViewObject();
                 ViewCriteria hdrVC = HdrVO.createViewCriteria();
                 ViewCriteriaRow hdrVcr = hdrVC.createViewCriteriaRow();
                 hdrVcr.setAttribute("FuneralReqId", obj);
                 hdrVC.addRow(hdrVcr);
                 HdrVO.applyViewCriteria(hdrVC);
                 HdrVO.executeQuery();
    }
    
    public void onClickStatusCount(ActionEvent actionEvent) {
                String statusType = ADFContext.getCurrent()
                                              .getPageFlowScope()
                                              .get("statusType") == null ? "ALL" : ADFContext.getCurrent()
                                                                                           .getPageFlowScope()
                                                                                           .get("statusType")
                                                                                           .toString();
        Object obj1 = ADFContext.getCurrent()
                               .getSessionScope()
                               .get("personId");
        System.err.println( "prsnid" + ADFContext.getCurrent()
                                   .getSessionScope()
                                   .get("personId"));
                ViewObject dashVo = ADFUtils.findIterator("XXSSHR_FUNERAL_SUPPORT_VOIterator").getViewObject();
                dashVo.applyViewCriteria(null);
                dashVo.executeQuery();
                if (!"ALL".equals(statusType)) {
                    ViewCriteria vc = dashVo.createViewCriteria();
                    ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
                    vcRow.setAttribute("ApprovalStatus", statusType);
                    vcRow.setAttribute("PersonId", obj1);
                    vc.addRow(vcRow);
                    dashVo.applyViewCriteria(vc);
                    dashVo.executeQuery();
                }else{
                    ViewCriteria vc = dashVo.createViewCriteria();
                    ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
                    vcRow.setAttribute("PersonId", obj1);
                    vc.addRow(vcRow);
                
                    dashVo.applyViewCriteria(vc);
                    dashVo.executeQuery();
                }
    }

    public void onClickDelete(ActionEvent actionEvent) {
        ViewObject dashVo = ADFUtils.findIterator("XXSSHR_FUNERAL_SUPPORT_VOIterator").getViewObject();
        dashVo.getCurrentRow().setAttribute("DeleteFlag", "Y");
        com.view.utils.ADFUtils.findOperation("Commit").execute();
        dashVo.executeQuery();
        // Add event code here...
    }

    public void onClickSubmit(ActionEvent actionEvent) {
        ViewObject HdrVO = ADFUtils.findIterator("XXSSHR_FUNERAL_SUPPORT_VOIterator").getViewObject();
                       ViewObjectImpl VO = (ViewObjectImpl) ADFUtils.findIterator("XXSSHR_FUNERAL_SUPPORT_VOIterator").getViewObject();
       
                       RowSetIterator iter = HdrVO.createRowSetIterator(null);
                       System.err.println(HdrVO.getCurrentRow().getAttribute("Trans_Active"));
        System.err.println( iter.getRowCount());
   
                       while (iter.hasNext()) {
                            Row r = iter.next();
System.err.println("INSIDE WHILE");
                           System.err.println("INSIDE WHILE" +r.getAttribute("Trans_Active"));
                           if (r.getAttribute("Trans_Active") != null && r.getAttribute("Trans_Active").equals("true")) {
//                              

                                   r.setAttribute("ApprovalStatus", "SUBMITTED FOR PAYROLL");
                                 
                               ADFUtils.findOperation("Commit").execute();
           
//                                   HdrVO.applyViewCriteria(HdrVO.getViewCriteriaManager().getViewCriteria("search_Vc"));
//                                    
//                                            HdrVO.executeQuery();
//                               }


                           }
                       }

                       String xmlData = null;
                       String[] a = null;
                       String payRollWSDL = null;
                       payRollWSDL = ApprovalPayload.PAYROLL_WSDL;
                       ViewObject HdrVo = ADFUtils.findIterator("XXSSHR_FUNERAL_SUPPORT_VOIterator").getViewObject();

                       String p_EmployeeNumber = "Test";

                       xmlData = ApprovalPayload.payrollTypeXMLData(p_EmployeeNumber);

                       System.err.println("xmlData =>" + xmlData);
                       a = ApprovalProcess.invokeWsdl(xmlData, payRollWSDL, ApprovalPayload.PAYROLL_METHOD);
                       if (a[0] != null && a[0].equals("True")) {
                           
                           HdrVo.executeQuery();
                           ADFContext.getCurrent()
                                                              .getPageFlowScope()
                                                              .put("showMsg" ,"Payroll Submitted Successfully");
                                       RichPopup.PopupHints hints = new RichPopup.PopupHints();
                                       myPopup.show(hints);
                                       AdfFacesContext.getCurrentInstance().addPartialTarget(messageBind);

// JSFUtils.addFacesInformationMessage("Request submitted successfully !");
                       } else {
                           
                           ADFUtils.findOperation("Rollback").execute();
                           VO.executeQuery();
                           HdrVo.executeQuery();
                           ADFContext.getCurrent()
                                                              .getPageFlowScope()
                                                              .put("showMsg" ,"Error");
                                       RichPopup.PopupHints hints = new RichPopup.PopupHints();
                                       myPopup.show(hints);
                                       AdfFacesContext.getCurrentInstance().addPartialTarget(messageBind);
                       
//                         JSFUtils.addFacesInformationMessage("Error");

                       }
    }

    public void setMessageBind(RichOutputText messageBind) {
        this.messageBind = messageBind;
    }

    public RichOutputText getMessageBind() {
        return messageBind;
    }
    public void hidePopup(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        getMyPopup().hide();
    }

    public void setMyPopup(RichPopup myPopup) {
        this.myPopup = myPopup;
    }

    public RichPopup getMyPopup() {
        return myPopup;
    }
}
