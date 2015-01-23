<?php
// To run this test, install Sausage (see http://github.com/jlipps/sausage-bun
// to get the curl one-liner to run in this directory), then run:
//     vendor/bin/phpunit SimpleTest.php

require_once "vendor/autoload.php";
define("APP_PATH", realpath(dirname(__FILE__).'/../../build/outputs/apk/GreenhouseCI-flavor1-debug.apk'));
if (!APP_PATH) {
    die("App did not exist!");
}

class SimpleTest extends Sauce\Sausage\WebDriverTestCase
{
    protected $numValues = array();

    public static $browsers = array(
        array(
            'local' => true,
            'port' => 4723,
            'browserName' => '',
            'desiredCapabilities' => array(
                'device' => 'nexus7',
                'deviceName' => 'Android emulator',
                'version' => '4.2',
                'platform' => 'Android',
                'platformName' => 'Android',
                'platformVersion' => '4.2',
                'app' => APP_PATH
            )
        )
    );

    public function elemsByTag($tag)
    {
        return $this->elements($this->using('tag name')->value($tag));
    }

    protected function populate()
    {
        $elems = $this->elemsByTag('textField');
        foreach ($elems as $elem) {
            $randNum = rand(0, 10);
            $elem->value($randNum);
            $this->numValues[] = $randNum;
        }
    }

    public function testUiComputation()
    {
        $this->assertEquals(true, true);
    }

    public function testFailedAssertion()
    {
        $this->assertEquals(true, false);
    }


    public function testUi()
    {
        echo("\nIn testUi\n");
        $elem = $this->byClassName('android.widget.TextView');
        $this->assertNotNull($elem);
        $this->assertEquals('GreenhouseCI', $elem->text());
    }
}
