package com.imolczek.liferay.lab.petstore.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

import com.imolczek.liferay.lab.petstore.service.PetApiLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.petstore",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.name=PetstorePortlet",
                "javax.portlet.display-name=Petstore Portlet",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/PetstorePortlet/view.jsp",
                "javax.portlet.security-role-ref=guest,power-user,user"
        },        
        service = Portlet.class
)
public class PetstorePortlet extends MVCPortlet {
	
    protected static final Logger LOG = Logger.getLogger(PetstorePortlet.class);
    
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		String petName;
		try {
			petName = petApiLocalServiceFactory.getService().getPetById(1l).getName();
			renderRequest.setAttribute("petName", petName );
		} catch (Exception e) {
			LOG.error(e);
		}
		
		super.doView(renderRequest, renderResponse);
	}
	
    private ComponentServiceObjects<PetApiLocalService> petApiLocalServiceFactory;

    @Reference(scope = ReferenceScope.PROTOTYPE)
    public void setCbsBestActionApiLocalServiceFactory(ComponentServiceObjects<PetApiLocalService> petApiLocalServiceFactory) {
        this.petApiLocalServiceFactory = petApiLocalServiceFactory;
    }        
    

}