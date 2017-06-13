/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.ibm.aemtrainig.core.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.Session;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

   
//This is a component so it can provide or consume services

@Component(
        label = "AAAAAAAAAAAAAAAAAAAAA",
        description = "AAAAAAAAAAAA",
        metatype = false,
        immediate = false
)
@Properties({
        @Property(
                name = "service.description",
                value = "AA",
                propertyPrivate = true
        ),
        @Property(
                label = "Workflow Label",
                name = "process.label",
                value = "PoojaWorkflow",
                description = "New Workflow created by Pooja"
        )
})
@Service
public class SampleWorkflow implements WorkflowProcess
{
       
      
/** Default log. */
protected final Logger log = LoggerFactory.getLogger(this.getClass());
public void execute(WorkItem item, WorkflowSession wfsession,MetaDataMap args) throws WorkflowException {  
try
{    
	log.debug("Let us start workflow process");
   String myPayload= item.getWorkflowData().getPayload().toString();
   log.debug("********Start of the Workflow*******"+myPayload);
   Session session=wfsession.adaptTo(Session.class);
   log.debug("*********Getting session from********");
   Node node=session.getNode(myPayload).getNode("jcr:content");
   log.debug("**************Path is**********"+node.getPath());
   String title=node.getProperty("jcr:title").getString();
   node.setProperty("jcr:title",title+"_pooja");
   session.save();
}
    catch (Exception e)
    {
    e.printStackTrace()  ; 
    }
 }
 
}