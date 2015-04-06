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

        self.driver = webdriver.Remote('http://localhost:4723/wd/hub', desired_caps)

    def tearDown(self):
        # end the session
        self.driver.quit()

    def test_find_text_views(self):
        tvs = self.driver.find_elements_by_class_name('android.widget.TextView')
        self.assertEqual(len(tvs), 2)

        navbar_tv = tvs[0]
        app_tv = tvs[1]

        self.assertTrue(navbar_tv.is_displayed())
        self.assertEqual(navbar_tv.text, 'GreenhouseCI')

        self.assertTrue(app_tv.is_displayed())
        self.assertEqual(app_tv.text, 'Thank you for building with GreenhouseCI!')


    def test_start_activity(self):
        activity = ".MainActivity"
        self.assertEqual(self.driver.current_activity, activity)


        self.driver.back()
        self.assertNotEqual(self.driver.current_activity, activity)

        self.driver.start_activity('com.greenhouseci','.MainActivity')
        self.assertEqual(self.driver.current_activity, activity)


if __name__ == '__main__':
    suite = unittest.TestLoader().loadTestsFromTestCase(SimpleAndroidTests)
    unittest.TextTestRunner(verbosity=2).run(suite)