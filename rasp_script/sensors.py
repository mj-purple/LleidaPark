import RPi.GPIO as GPIO
import requests

URL = "http://192.168.237.224:8080/spot"
BEAM_PIN = 17

def break_beam_callback(channel):
	requests.put(URL, json={"id":1, "isOccupied":"false" if GPIO.input(BEAM_PIN) else "true"})

GPIO.setmode(GPIO.BCM)
GPIO.setup(BEAM_PIN, GPIO.IN, pull_up_down=GPIO.PUD_UP)
GPIO.add_event_detect(BEAM_PIN, GPIO.BOTH, callback=break_beam_callback)

message = input("Press enter to quit\n\n")
GPIO.cleanup()
