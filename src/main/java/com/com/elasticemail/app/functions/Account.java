package com.com.elasticemail.app.functions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Date;

import java.util.UUID;

import com.elasticemail.app.API;
import com.elasticemail.app.ApiTypes;
import com.elasticemail.app.ApiTypes.*;
import com.elasticemail.app.FileData;
import com.elasticemail.app.APIResponse.VoidApiResponse;

/**
 * Methods for managing your account and subaccounts.
 */
public class Account extends API
{
    /**
     * Request premium support for your account
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param supportPlan 
     * @throws Exception
     */
    public void addDedicatedSupport(SupportPlan supportPlan) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("supportPlan", String.valueOf(supportPlan));
       uploadValues(API_URI + "/account/adddedicatedsupport", values, VoidApiResponse.class);
   }

    /**
     * Create new subaccount and provide most important data about it.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param email Proper email address.
     * @param password Current password.
     * @param confirmPassword Repeat new password.
     * @param allow2fa True, if you want to allow two-factor authentication.  Otherwise, false.
     * @param requiresEmailCredits True, if Account needs credits to send emails. Otherwise, false
     * @param maxContacts Maximum number of contacts the Account can have
     * @param enablePrivateIPRequest True, if Account can request for private IP on its own. Otherwise, false
     * @param sendActivation True, if you want to send activation email to this Account. Otherwise, false
     * @param returnUrl URL to navigate to after Account creation
     * @param sendingPermission Sending permission setting for Account
     * @param enableContactFeatures Private IP required. Name of the custom IP Pool which Sub Account should use to send its emails. Leave empty for the default one or if no Private IPs have been bought
     * @param poolName Name of your custom IP Pool to be used in the sending process
     * @param emailSizeLimit Maximum size of email including attachments in MB's
     * @param dailySendLimit Amount of emails Account can send daily
     * @return String
     * @throws Exception
     */
    public String addSubAccount(String email, String password, String confirmPassword, Boolean allow2fa, Boolean requiresEmailCredits, int maxContacts, Boolean enablePrivateIPRequest, Boolean sendActivation, String returnUrl, SendingPermission sendingPermission, Boolean enableContactFeatures, String poolName, int emailSizeLimit, int dailySendLimit) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("email", email);
       values.put("password", password);
       values.put("confirmPassword", confirmPassword);
       values.put("allow2fa", String.valueOf(allow2fa));
       values.put("requiresEmailCredits", String.valueOf(requiresEmailCredits));
       values.put("maxContacts", String.valueOf(maxContacts));
       values.put("enablePrivateIPRequest", String.valueOf(enablePrivateIPRequest));
       values.put("sendActivation", String.valueOf(sendActivation));
       values.put("returnUrl", returnUrl);
       if (sendingPermission != null) values.put("sendingPermission", String.valueOf(sendingPermission));
       values.put("enableContactFeatures", String.valueOf(enableContactFeatures));
       values.put("poolName", poolName);
       values.put("emailSizeLimit", String.valueOf(emailSizeLimit));
       values.put("dailySendLimit", String.valueOf(dailySendLimit));
       return uploadValues(API_URI + "/account/addsubaccount", values, String.class);
   }

    /**
     * Add email credits to a sub-account
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param credits Amount of credits to add
     * @param notes Specific notes about the transaction
     * @param subAccountEmail Email address of Sub-Account
     * @param publicAccountID Public key of sub-account to add credits to. Use subAccountEmail or publicAccountID not both.
     * @throws Exception
     */
    public void addSubAccountCredits(int credits, String notes, String subAccountEmail, String publicAccountID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("credits", String.valueOf(credits));
       values.put("notes", notes);
       values.put("subAccountEmail", subAccountEmail);
       values.put("publicAccountID", publicAccountID);
       uploadValues(API_URI + "/account/addsubaccountcredits", values, VoidApiResponse.class);
   }

    /**
     * Add notifications webhook
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param webNotificationUrl URL address to receive web notifications to parse and process.
     * @param name Filename
     * @param notifyOncePerEmail 
     * @param notificationForSent 
     * @param notificationForOpened 
     * @param notificationForClicked 
     * @param notificationForUnsubscribed 
     * @param notificationForAbuseReport 
     * @param notificationForError 
     * @return String
     * @throws Exception
     */
    public String addWebhook(String webNotificationUrl, String name, Boolean notifyOncePerEmail, Boolean notificationForSent, Boolean notificationForOpened, Boolean notificationForClicked, Boolean notificationForUnsubscribed, Boolean notificationForAbuseReport, Boolean notificationForError) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("webNotificationUrl", webNotificationUrl);
       values.put("name", name);
       values.put("notifyOncePerEmail", String.valueOf(notifyOncePerEmail));
       values.put("notificationForSent", String.valueOf(notificationForSent));
       values.put("notificationForOpened", String.valueOf(notificationForOpened));
       values.put("notificationForClicked", String.valueOf(notificationForClicked));
       values.put("notificationForUnsubscribed", String.valueOf(notificationForUnsubscribed));
       values.put("notificationForAbuseReport", String.valueOf(notificationForAbuseReport));
       values.put("notificationForError", String.valueOf(notificationForError));
       return uploadValues(API_URI + "/account/addwebhook", values, String.class);
   }

    /**
     * Change your email address. Remember, that your email address is used as login!
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param password Current password.
     * @param newEmail New email address.
     * @param confirmEmail New email address.
     * @param sourceUrl URL from which request was sent.
     * @return String
     * @throws Exception
     */
    public String changeEmail(String password, String newEmail, String confirmEmail, String sourceUrl) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("password", password);
       values.put("newEmail", newEmail);
       values.put("confirmEmail", confirmEmail);
       values.put("sourceUrl", sourceUrl);
       return uploadValues(API_URI + "/account/changeemail", values, String.class);
   }

    /**
     * Create new password for your account. Password needs to be at least 6 characters long.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param newPassword New password for Account.
     * @param confirmPassword Repeat new password.
     * @param resetApiKey 
     * @param currentPassword Current password.
     * @throws Exception
     */
    public void changePassword(String newPassword, String confirmPassword, Boolean resetApiKey, String currentPassword) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("newPassword", newPassword);
       values.put("confirmPassword", confirmPassword);
       values.put("resetApiKey", String.valueOf(resetApiKey));
       values.put("currentPassword", currentPassword);
       uploadValues(API_URI + "/account/changepassword", values, VoidApiResponse.class);
   }

    /**
     * Create new password for subaccount. Password needs to be at least 6 characters long.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param newPassword New password for Account.
     * @param confirmPassword Repeat new password.
     * @param subAccountEmail Email address of Sub-Account
     * @param resetApiKey 
     * @throws Exception
     */
    public void changeSubAccountPassword(String newPassword, String confirmPassword, String subAccountEmail, Boolean resetApiKey) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("newPassword", newPassword);
       values.put("confirmPassword", confirmPassword);
       values.put("subAccountEmail", subAccountEmail);
       values.put("resetApiKey", String.valueOf(resetApiKey));
       uploadValues(API_URI + "/account/changesubaccountpassword", values, VoidApiResponse.class);
   }

    /**
     * Deletes specified Subaccount
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param subAccountEmail Email address of Sub-Account
     * @param publicAccountID Public key of sub-account to delete. Use subAccountEmail or publicAccountID not both.
     * @throws Exception
     */
    public void deleteSubAccount(String subAccountEmail, String publicAccountID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("subAccountEmail", subAccountEmail);
       values.put("publicAccountID", publicAccountID);
       uploadValues(API_URI + "/account/deletesubaccount", values, VoidApiResponse.class);
   }

    /**
     * Delete notifications webhook
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param webhookID 
     * @throws Exception
     */
    public void deleteWebhook(String webhookID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("webhookID", webhookID);
       uploadValues(API_URI + "/account/deletewebhook", values, VoidApiResponse.class);
   }

    /**
     * Returns API Key for the given Sub Account.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param subAccountEmail Email address of Sub-Account
     * @param publicAccountID Public key of sub-account to retrieve sub-account API Key. Use subAccountEmail or publicAccountID not both.
     * @return String
     * @throws Exception
     */
    public String getSubAccountApiKey(String subAccountEmail, String publicAccountID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("subAccountEmail", subAccountEmail);
       values.put("publicAccountID", publicAccountID);
       return uploadValues(API_URI + "/account/getsubaccountapikey", values, String.class);
   }

    /**
     * Lists all of your subaccounts
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param limit Maximum number of returned items.
     * @param offset How many items should be returned ahead.
     * @param email Proper email address.
     * @return ApiTypes.SubAccountArray
     * @throws Exception
     */
    public SubAccountArray getSubAccountList(int limit, int offset, String email) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       values.put("email", email);
       return uploadValues(API_URI + "/account/getsubaccountlist", values, SubAccountArray.class);
   }

    /**
     * Loads your account. Returns detailed information about your account.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @return ApiTypes.Account
     * @throws Exception
     */
    public ApiTypes.Account load() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/account/load", values, ApiTypes.Account.class);
   }

    /**
     * Load advanced options of your account
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @return ApiTypes.AdvancedOptions
     * @throws Exception
     */
    public AdvancedOptions loadAdvancedOptions() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/account/loadadvancedoptions", values, AdvancedOptions.class);
   }

    /**
     * Lists email credits history
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @return ApiTypes.EmailCreditsArray
     * @throws Exception
     */
    public EmailCreditsArray loadEmailCreditsHistory() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/account/loademailcreditshistory", values, EmailCreditsArray.class);
   }

    /**
     * Load inbound options of your account
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @return ApiTypes.InboundOptions
     * @throws Exception
     */
    public InboundOptions loadInboundOptions() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/account/loadinboundoptions", values, InboundOptions.class);
   }

    /**
     * Lists all payments
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param limit Maximum number of returned items.
     * @param offset How many items should be returned ahead.
     * @param fromDate Starting date for search in YYYY-MM-DDThh:mm:ss format.
     * @param toDate Ending date for search in YYYY-MM-DDThh:mm:ss format.
     * @return ApiTypes.PaymentArray
     * @throws Exception
     */
    public PaymentArray loadPaymentHistory(int limit, int offset, Date fromDate, Date toDate) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       values.put("fromDate", String.valueOf(fromDate));
       values.put("toDate", String.valueOf(toDate));
       return uploadValues(API_URI + "/account/loadpaymenthistory", values, PaymentArray.class);
   }

    /**
     * Lists all referral payout history
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @return ApiTypes.PaymentArray
     * @throws Exception
     */
    public PaymentArray loadPayoutHistory() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/account/loadpayouthistory", values, PaymentArray.class);
   }

    /**
     * Shows information about your referral details
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @return ApiTypes.Referral
     * @throws Exception
     */
    public Referral loadReferralDetails() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/account/loadreferraldetails", values, Referral.class);
   }

    /**
     * Shows latest changes in your sending reputation
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @return ApiTypes.ReputationHistoryArray
     * @throws Exception
     */
    public ReputationHistoryArray loadReputationHistory() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/account/loadreputationhistory", values, ReputationHistoryArray.class);
   }

    /**
     * Shows detailed information about your actual reputation score
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @return ApiTypes.ReputationDetail
     * @throws Exception
     */
    public ReputationDetail loadReputationImpact() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/account/loadreputationimpact", values, ReputationDetail.class);
   }

    /**
     * Returns detailed spam check.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param limit Maximum number of returned items.
     * @param offset How many items should be returned ahead.
     * @return ApiTypes.SpamCheckArray
     * @throws Exception
     */
    public SpamCheckArray loadSpamCheck(int limit, int offset) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       return uploadValues(API_URI + "/account/loadspamcheck", values, SpamCheckArray.class);
   }

    /**
     * Lists email credits history for sub-account
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param subAccountEmail Email address of Sub-Account
     * @param publicAccountID Public key of sub-account to list history for. Use subAccountEmail or publicAccountID not both.
     * @return ApiTypes.EmailCreditsArray
     * @throws Exception
     */
    public EmailCreditsArray loadSubAccountsEmailCreditsHistory(String subAccountEmail, String publicAccountID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("subAccountEmail", subAccountEmail);
       values.put("publicAccountID", publicAccountID);
       return uploadValues(API_URI + "/account/loadsubaccountsemailcreditshistory", values, EmailCreditsArray.class);
   }

    /**
     * Loads settings of subaccount
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param subAccountEmail Email address of Sub-Account
     * @param publicAccountID Public key of sub-account to load settings for. Use subAccountEmail or publicAccountID not both.
     * @return ApiTypes.SubAccountSettings
     * @throws Exception
     */
    public SubAccountSettings loadSubAccountSettings(String subAccountEmail, String publicAccountID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("subAccountEmail", subAccountEmail);
       values.put("publicAccountID", publicAccountID);
       return uploadValues(API_URI + "/account/loadsubaccountsettings", values, SubAccountSettings.class);
   }

    /**
     * Shows usage of your account in given time.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param from Starting date for search in YYYY-MM-DDThh:mm:ss format.
     * @param to Ending date for search in YYYY-MM-DDThh:mm:ss format.
     * @param loadSubaccountsUsage 
     * @return ApiTypes.UsageArray
     * @throws Exception
     */
    public UsageArray loadUsage(Date from, Date to, Boolean loadSubaccountsUsage) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("from", String.valueOf(from));
       values.put("to", String.valueOf(to));
       values.put("loadSubaccountsUsage", String.valueOf(loadSubaccountsUsage));
       return uploadValues(API_URI + "/account/loadusage", values, UsageArray.class);
   }

    /**
     * Load notifications webhooks
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param limit Maximum number of returned items.
     * @param offset How many items should be returned ahead.
     * @return ApiTypes.WebhookArray
     * @throws Exception
     */
    public WebhookArray loadWebhook(int limit, int offset) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       return uploadValues(API_URI + "/account/loadwebhook", values, WebhookArray.class);
   }

    /**
     * Load web notification options of your account
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @return ApiTypes.WebNotificationOptions
     * @throws Exception
     */
    public WebNotificationOptions loadWebNotificationOptions() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/account/loadwebnotificationoptions", values, WebNotificationOptions.class);
   }

    /**
     * Shows summary for your account.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @return ApiTypes.AccountOverview
     * @throws Exception
     */
    public AccountOverview overview() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/account/overview", values, AccountOverview.class);
   }

    /**
     * Shows you account's profile basic overview
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @return ApiTypes.Profile
     * @throws Exception
     */
    public Profile profileOverview() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/account/profileoverview", values, Profile.class);
   }

    /**
     * Remove email credits from a sub-account
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param notes Specific notes about the transaction
     * @param subAccountEmail Email address of Sub-Account
     * @param publicAccountID Public key of sub-account to remove credits from. Use subAccountEmail or publicAccountID not both.
     * @param credits Amount of credits to remove
     * @param removeAll Remove all credits of this type from sub-account (overrides credits if provided)
     * @throws Exception
     */
    public void removeSubAccountCredits(String notes, String subAccountEmail, String publicAccountID, int credits, Boolean removeAll) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("notes", notes);
       values.put("subAccountEmail", subAccountEmail);
       values.put("publicAccountID", publicAccountID);
       values.put("credits", String.valueOf(credits));
       values.put("removeAll", String.valueOf(removeAll));
       uploadValues(API_URI + "/account/removesubaccountcredits", values, VoidApiResponse.class);
   }

    /**
     * Request a new default APIKey.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @return String
     * @throws Exception
     */
    public String requestNewApiKey() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/account/requestnewapikey", values, String.class);
   }

    /**
     * Request a private IP for your Account
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param count Number of items.
     * @param notes Free form field of notes
     * @throws Exception
     */
    public void requestPrivateIP(int count, String notes) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("count", String.valueOf(count));
       values.put("notes", notes);
       uploadValues(API_URI + "/account/requestprivateip", values, VoidApiResponse.class);
   }

    /**
     * Update sending and tracking options of your account.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param enableClickTracking True, if you want to track clicks. Otherwise, false
     * @param enableLinkClickTracking True, if you want to track by link tracking. Otherwise, false
     * @param manageSubscriptions True, if you want to display your labels on your unsubscribe form. Otherwise, false
     * @param manageSubscribedOnly True, if you want to only display labels that the contact is subscribed to on your unsubscribe form. Otherwise, false
     * @param transactionalOnUnsubscribe True, if you want to display an option for the contact to opt into transactional email only on your unsubscribe form. Otherwise, false
     * @param skipListUnsubscribe True, if you do not want to use list-unsubscribe headers. Otherwise, false
     * @param autoTextFromHtml True, if text BODY of message should be created automatically. Otherwise, false
     * @param allowCustomHeaders True, if you want to apply custom headers to your emails. Otherwise, false
     * @param bccEmail Email address to send a copy of all email to.
     * @param contentTransferEncoding Type of content encoding
     * @param emailNotificationForError True, if you want bounce notifications returned. Otherwise, false
     * @param emailNotificationEmail Specific email address to send bounce email notifications to.
     * @param lowCreditNotification True, if you want to receive low credit email notifications. Otherwise, false
     * @param enableUITooltips True, if Account has tooltips active. Otherwise, false
     * @param notificationsEmails Email addresses to send a copy of all notifications from our system. Separated by semicolon
     * @param unsubscribeNotificationsEmails Emails, separated by semicolon, to which the notification about contact unsubscribing should be sent to
     * @param logoUrl URL to your logo image.
     * @param enableTemplateScripting True, if you want to use template scripting in your emails {{}}. Otherwise, false
     * @param staleContactScore (0 means this functionality is NOT enabled) Score, depending on the number of times you have sent to a recipient, at which the given recipient should be moved to the Stale status
     * @param staleContactInactiveDays (0 means this functionality is NOT enabled) Number of days of inactivity for a contact after which the given recipient should be moved to the Stale status
     * @param deliveryReason Why your clients are receiving your emails.
     * @param tutorialsEnabled True, if you want to enable Dashboard Tutotials
     * @param enableOpenTracking True, if you want to track opens. Otherwise, false
     * @param consentTrackingOnUnsubscribe 
     * @return ApiTypes.AdvancedOptions
     * @throws Exception
     */
    public AdvancedOptions updateAdvancedOptions(Boolean enableClickTracking, Boolean enableLinkClickTracking, Boolean manageSubscriptions, Boolean manageSubscribedOnly, Boolean transactionalOnUnsubscribe, Boolean skipListUnsubscribe, Boolean autoTextFromHtml, Boolean allowCustomHeaders, String bccEmail, String contentTransferEncoding, Boolean emailNotificationForError, String emailNotificationEmail, Boolean lowCreditNotification, Boolean enableUITooltips, String notificationsEmails, String unsubscribeNotificationsEmails, String logoUrl, Boolean enableTemplateScripting, int staleContactScore, int staleContactInactiveDays, String deliveryReason, Boolean tutorialsEnabled, Boolean enableOpenTracking, Boolean consentTrackingOnUnsubscribe) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("enableClickTracking", String.valueOf(enableClickTracking));
       values.put("enableLinkClickTracking", String.valueOf(enableLinkClickTracking));
       values.put("manageSubscriptions", String.valueOf(manageSubscriptions));
       values.put("manageSubscribedOnly", String.valueOf(manageSubscribedOnly));
       values.put("transactionalOnUnsubscribe", String.valueOf(transactionalOnUnsubscribe));
       values.put("skipListUnsubscribe", String.valueOf(skipListUnsubscribe));
       values.put("autoTextFromHtml", String.valueOf(autoTextFromHtml));
       values.put("allowCustomHeaders", String.valueOf(allowCustomHeaders));
       values.put("bccEmail", bccEmail);
       values.put("contentTransferEncoding", contentTransferEncoding);
       values.put("emailNotificationForError", String.valueOf(emailNotificationForError));
       values.put("emailNotificationEmail", emailNotificationEmail);
       values.put("lowCreditNotification", String.valueOf(lowCreditNotification));
       values.put("enableUITooltips", String.valueOf(enableUITooltips));
       values.put("notificationsEmails", notificationsEmails);
       values.put("unsubscribeNotificationsEmails", unsubscribeNotificationsEmails);
       values.put("logoUrl", logoUrl);
       values.put("enableTemplateScripting", String.valueOf(enableTemplateScripting));
       values.put("staleContactScore", String.valueOf(staleContactScore));
       values.put("staleContactInactiveDays", String.valueOf(staleContactInactiveDays));
       values.put("deliveryReason", deliveryReason);
       values.put("tutorialsEnabled", String.valueOf(tutorialsEnabled));
       values.put("enableOpenTracking", String.valueOf(enableOpenTracking));
       values.put("consentTrackingOnUnsubscribe", String.valueOf(consentTrackingOnUnsubscribe));
       return uploadValues(API_URI + "/account/updateadvancedoptions", values, AdvancedOptions.class);
   }

    /**
     * Update settings of your private branding. These settings are needed, if you want to use Elastic Email under your brand.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param enablePrivateBranding True: Turn on or off ability to send mails under your brand. Otherwise, false
     * @param logoUrl URL to your logo image.
     * @param supportLink Address to your support.
     * @param privateBrandingUrl Subdomain for your rebranded service
     * @param smtpAddress Address of SMTP server.
     * @param smtpAlternative Address of alternative SMTP server.
     * @param paymentUrl URL for making payments.
     * @param customBouncesDomain 
     * @throws Exception
     */
    public void updateCustomBranding(Boolean enablePrivateBranding, String logoUrl, String supportLink, String privateBrandingUrl, String smtpAddress, String smtpAlternative, String paymentUrl, String customBouncesDomain) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("enablePrivateBranding", String.valueOf(enablePrivateBranding));
       values.put("logoUrl", logoUrl);
       values.put("supportLink", supportLink);
       values.put("privateBrandingUrl", privateBrandingUrl);
       values.put("smtpAddress", smtpAddress);
       values.put("smtpAlternative", smtpAlternative);
       values.put("paymentUrl", paymentUrl);
       values.put("customBouncesDomain", customBouncesDomain);
       uploadValues(API_URI + "/account/updatecustombranding", values, VoidApiResponse.class);
   }

    /**
     * Update inbound notifications options of your account.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param inboundContactsOnly True, if you want inbound email to only process contacts from your Account. Otherwise, false
     * @param hubCallBackUrl URL used for tracking action of inbound emails
     * @param inboundDomain Domain you use as your inbound domain
     * @return ApiTypes.InboundOptions
     * @throws Exception
     */
    public InboundOptions updateInboundNotifications(Boolean inboundContactsOnly, String hubCallBackUrl, String inboundDomain) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("inboundContactsOnly", String.valueOf(inboundContactsOnly));
       values.put("hubCallBackUrl", hubCallBackUrl);
       values.put("inboundDomain", inboundDomain);
       return uploadValues(API_URI + "/account/updateinboundnotifications", values, InboundOptions.class);
   }

    /**
     * Update your profile.
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param firstName First name.
     * @param lastName Last name.
     * @param address1 First line of address.
     * @param city City.
     * @param state State or province.
     * @param zip Zip/postal code.
     * @param countryID Numeric ID of country. A file with the list of countries is available <a href="http://api.elasticemail.com/public/countries"><b>here</b></a>
     * @param marketingConsent True if you want to receive newsletters from Elastic Email. Otherwise, false. Empty to leave the current value.
     * @param address2 Second line of address.
     * @param company Company name.
     * @param website HTTP address of your website.
     * @param logoUrl URL to your logo image.
     * @param taxCode Code used for tax purposes.
     * @param phone Phone number
     * @throws Exception
     */
    public void updateProfile(String firstName, String lastName, String address1, String city, String state, String zip, int countryID, Boolean marketingConsent, String address2, String company, String website, String logoUrl, String taxCode, String phone) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("firstName", firstName);
       values.put("lastName", lastName);
       values.put("address1", address1);
       values.put("city", city);
       values.put("state", state);
       values.put("zip", zip);
       values.put("countryID", String.valueOf(countryID));
       values.put("marketingConsent", String.valueOf(marketingConsent));
       values.put("address2", address2);
       values.put("company", company);
       values.put("website", website);
       values.put("logoUrl", logoUrl);
       values.put("taxCode", taxCode);
       values.put("phone", phone);
       uploadValues(API_URI + "/account/updateprofile", values, VoidApiResponse.class);
   }

    /**
     * Updates settings of specified subaccount
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param requiresEmailCredits True, if Account needs credits to send emails. Otherwise, false
     * @param allow2fa True, if you want to allow two-factor authentication.  Otherwise, false.
     * @param monthlyRefillCredits Amount of credits added to Account automatically
     * @param dailySendLimit Amount of emails Account can send daily
     * @param emailSizeLimit Maximum size of email including attachments in MB's
     * @param enablePrivateIPRequest True, if Account can request for private IP on its own. Otherwise, false
     * @param maxContacts Maximum number of contacts the Account can have
     * @param subAccountEmail Email address of Sub-Account
     * @param publicAccountID Public key of sub-account to update. Use subAccountEmail or publicAccountID not both.
     * @param sendingPermission Sending permission setting for Account
     * @param enableContactFeatures True, if you want to use Contact Delivery Tools.  Otherwise, false
     * @param poolName Name of your custom IP Pool to be used in the sending process
     * @throws Exception
     */
    public void updateSubAccountSettings(Boolean requiresEmailCredits, Boolean allow2fa, int monthlyRefillCredits, int dailySendLimit, int emailSizeLimit, Boolean enablePrivateIPRequest, int maxContacts, String subAccountEmail, String publicAccountID, SendingPermission sendingPermission, Boolean enableContactFeatures, String poolName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("requiresEmailCredits", String.valueOf(requiresEmailCredits));
       values.put("allow2fa", String.valueOf(allow2fa));
       values.put("monthlyRefillCredits", String.valueOf(monthlyRefillCredits));
       values.put("dailySendLimit", String.valueOf(dailySendLimit));
       values.put("emailSizeLimit", String.valueOf(emailSizeLimit));
       values.put("enablePrivateIPRequest", String.valueOf(enablePrivateIPRequest));
       values.put("maxContacts", String.valueOf(maxContacts));
       values.put("subAccountEmail", subAccountEmail);
       values.put("publicAccountID", publicAccountID);
       if (sendingPermission != null) values.put("sendingPermission", String.valueOf(sendingPermission));
       values.put("enableContactFeatures", String.valueOf(enableContactFeatures));
       values.put("poolName", poolName);
       uploadValues(API_URI + "/account/updatesubaccountsettings", values, VoidApiResponse.class);
   }

    /**
     * Update notification webhook
     * @param apikey ApiKey that gives you access to our SMTP and HTTP API's.
     * @param webhookID 
     * @param name Filename
     * @param webNotificationUrl URL address to receive web notifications to parse and process.
     * @param notifyOncePerEmail 
     * @param notificationForSent 
     * @param notificationForOpened 
     * @param notificationForClicked 
     * @param notificationForUnsubscribed 
     * @param notificationForAbuseReport 
     * @param notificationForError 
     * @throws Exception
     */
    public void updateWebhook(String webhookID, String name, String webNotificationUrl, Boolean notifyOncePerEmail, Boolean notificationForSent, Boolean notificationForOpened, Boolean notificationForClicked, Boolean notificationForUnsubscribed, Boolean notificationForAbuseReport, Boolean notificationForError) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("webhookID", webhookID);
       values.put("name", name);
       values.put("webNotificationUrl", webNotificationUrl);
       values.put("notifyOncePerEmail", String.valueOf(notifyOncePerEmail));
       values.put("notificationForSent", String.valueOf(notificationForSent));
       values.put("notificationForOpened", String.valueOf(notificationForOpened));
       values.put("notificationForClicked", String.valueOf(notificationForClicked));
       values.put("notificationForUnsubscribed", String.valueOf(notificationForUnsubscribed));
       values.put("notificationForAbuseReport", String.valueOf(notificationForAbuseReport));
       values.put("notificationForError", String.valueOf(notificationForError));
       uploadValues(API_URI + "/account/updatewebhook", values, VoidApiResponse.class);
   }

}

