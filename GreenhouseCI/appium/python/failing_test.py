import os
from time import sleep

import unittest

from appium import webdriver

# Returns abs path relative to this file and not cwd
PATH = lambda p: os.path.abspath(
    os.path.join(os.path.dirname(__file__), p)
)

class SimpleAndroidTests(unittest.TestCase):
    def setUp(self):
        desired_caps = {}
        desired_caps['platformName'] = 'Android'
        desired_caps['platformVersion'] = '4.2'
        desired_caps['deviceName'] = 'Android Emulator'
        desired_caps['app'] = PATH('../../build/outputs/apk/GreenhouseCI-debug.apk')

        self.driver = webdriver.Remote('http://0.0.0.0:4723/wd/hub', desired_caps)

    def tearDown(self):
        # end the session
        self.driver.quit()

    def test_fail_text_mismatch(self):
        tv = self.driver.find_element_by_class_name('android.widget.TextView')
        self.assertEqual(tv.text, 'This text is not in app')

    def test_textview_displayed(self):
        tv = self.driver.find_element_by_class_name('android.widget.TextView')
        self.assertFalse(tv.is_displayed())


if __name__ == '__main__':
    suite = unittest.TestLoader().loadTestsFromTestCase(SimpleAndroidTests)
    unittest.TextTestRunner(verbosity=2).run(suite)
