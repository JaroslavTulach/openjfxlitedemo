package OpenJFXLiteDemo;

import com.dukescript.api.javafx.beans.ActionDataEvent;
import com.dukescript.api.javafx.beans.FXBeanInfo;
import java.util.Arrays;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

@FXBeanInfo.Generate
public class RootViewModel extends RootViewModelBase {

    /*
     function RootViewModel() {
       var self = this;

      // Media queries for repsonsive layouts
      var smQuery = ResponsiveUtils.getFrameworkQuery(ResponsiveUtils.FRAMEWORK_QUERY_KEY.SM_ONLY);
      self.smScreen = ResponsiveKnockoutUtils.createMediaQueryObservable(smQuery);

      // Header
      // Application Name used in Branding Area
      self.appName = ko.observable("App Name");
      // User Info used in Global Navigation area
      self.userLogin = ko.observable("john.hancock@oracle.com");

      // Footer
      function footerLink(id, id, disabled) {
        this.id = id;
        this.label = id;
        this.disabled = disabled;
      }
      self.footerLinks = ko.observableArray([
        new footerLink('About Oracle', 'aboutOracle', 'http://www.oracle.com/us/corporate/index.html#menu-about'),
        new footerLink('Contact Us', 'contactUs', 'http://www.oracle.com/us/corporate/contact/index.html'),
        new footerLink('Legal Notices', 'legalNotices', 'http://www.oracle.com/us/legal/index.html'),
        new footerLink('Terms Of Use', 'termsOfUse', 'http://www.oracle.com/us/legal/terms/index.html'),
        new footerLink('Your Privacy Rights', 'yourPrivacyRights', 'http://www.oracle.com/us/legal/privacy/index.html')
      ]);
     }

     return new RootViewModel();
     */
    final BooleanProperty smScreen = new SimpleBooleanProperty(this, "smScreen", false);
    final StringProperty appName = new SimpleStringProperty(this, "appName", "App Name");
    final StringProperty selectedItem = new SimpleStringProperty(this, "selectedItem", "dashboard");
    final StringProperty userLogin = new SimpleStringProperty(this, "userLogin", "john.hancock@oracle.com");
    final ListProperty<FooterLink> footerLinks = new SimpleListProperty<>(this, "footerLinks", FXCollections.observableArrayList());
    final ListProperty<NavItem> listItems = new SimpleListProperty<>(this, "listItems", FXCollections.observableArrayList());

    public RootViewModel() {
        listItems.addAll(Arrays.asList(
                new NavItem("dashboard", "Dashboard", false),
                new NavItem("customers", "Customers", false),
                new NavItem("incidents", "Incidents", false),
                new NavItem("about", "About", false)
        ));
        footerLinks.addAll(Arrays.asList(
                new FooterLink("About Oracle", "aboutOracle", "http://www.oracle.com/us/corporate/index.html#menu-about"),
                new FooterLink("Contact Us", "contactUs", "http://www.oracle.com/us/corporate/contact/index.html"),
                new FooterLink("Legal Notices", "legalNotices", "http://www.oracle.com/us/legal/index.html"),
                new FooterLink("Terms Of Use", "termsOfUse", "http://www.oracle.com/us/legal/terms/index.html"),
                new FooterLink("Your Privacy Rights", "yourPrivacyRights", "http://www.oracle.com/us/legal/privacy/index.html")
        ));
    }

    private void changeUserLoginCase() {
        if (Character.isUpperCase(userLogin.get().charAt(0))) {
            userLogin.set(userLogin.get().toLowerCase());
        } else {
            userLogin.set(userLogin.get().toUpperCase());
        }
    }

    @FXBeanInfo.Generate
    class NavItem extends NavItemBase {

        final String id;
        final String label;
        final boolean disabled;

        public NavItem(String id, String label, boolean disabled) {
            this.id = id;
            this.label = label;
            this.disabled = disabled;
        }

        void onClick(ActionDataEvent ade) {
            changeUserLoginCase();
        }
    }

    @FXBeanInfo.Generate
    class FooterLink extends FooterLinkBase {

        final String name;
        final String linkId;
        final String linkTarget;

        public FooterLink(String name, String linkId, String linkTarget) {
            this.name = name;
            this.linkId = linkId;
            this.linkTarget = linkTarget;
        }

        void onClick(ActionDataEvent ade) {
            changeUserLoginCase();
        }
    }
}
