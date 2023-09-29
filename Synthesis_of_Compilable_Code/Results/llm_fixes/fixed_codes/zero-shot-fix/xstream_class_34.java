import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class xstream_class_34 {
    @XStreamAlias("config") 
    public static class ConfigParameters extends com.thoughtworks.xstream.ParameterHolder { 
        @XStreamImplicit(itemFieldName = "resource") 
        private List<com.thoughtworks.xstream.ResourceSettings> resources; 
        
        @XStreamImplicit(itemFieldName = "env") 
        private List<com.thoughtworks.xstream.Environment> environments; 
        
        public ConfigParameters() { 
        } 
        
        public List<com.thoughtworks.xstream.Environment> getEnvironments() { 
            if (environments == null) 
                environments = new ArrayList<com.thoughtworks.xstream.Environment>(); 
            return environments; 
        } 
        
        public void setEnvironments(List<com.thoughtworks.xstream.Environment> environments) { 
            this.environments = environments; 
        } 
        
        public void setEnvironment(com.thoughtworks.xstream.Environment environment) { 
            deleteEnvironment(environment.getName()); 
            getEnvironments().add(environment); 
        } 
        
        public com.thoughtworks.xstream.Environment getEnvironment(String env) { 
            for (com.thoughtworks.xstream.Environment environment: getEnvironments()) { 
                if (env.equals(environment.getName())) 
                    return environment; 
            } 
            return null; 
        } 
        public void deleteEnvironment(String name) { 
            Iterator<com.thoughtworks.xstream.Environment> it = getEnvironments().iterator(); 
            while (it.hasNext()) { 
                if (it.next().getName().equals(name)) { 
                    it.remove(); 
                } 
            } 
        } 
        
        public List<com.thoughtworks.xstream.ResourceSettings> getResources() { 
            if (resources == null) 
                resources = new ArrayList<com.thoughtworks.xstream.ResourceSettings>(); 
            return resources; 
        } 
    }
}