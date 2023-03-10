
--source include/not_embedded.inc

if (!$PAM_PLUGIN_VERSION) {
  skip No pam auth plugin;
}

eval install plugin pam soname '$PAM_PLUGIN_VERSION';
create user test_pam identified via pam using 'mariadb_mtr';
grant all on test.* to test_pam;
create user pam_test;
grant all on test.* to pam_test;
grant proxy on pam_test to test_pam;

let $plugindir=`SELECT @@global.plugin_dir`;

