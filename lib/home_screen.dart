import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({Key? key}) : super(key: key);

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  static const appChannel = MethodChannel('com.background_service');

  void startService() async {
    dynamic value = await appChannel.invokeMethod('startService');
    print(value);
  }

  void stopService() async {
    dynamic value = await appChannel.invokeMethod('stopService');
    print(value);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Center(
              child: ElevatedButton(
                onPressed: () {
                  startService();
                },
                child: const Text(
                  'Start player',
                  style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
                ),
              ),
            ),
            const SizedBox(
              height: 20,
            ),
            Center(
              child: ElevatedButton(
                onPressed: () {
                  stopService();
                },
                child: const Text(
                  'Stop player',
                  style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
