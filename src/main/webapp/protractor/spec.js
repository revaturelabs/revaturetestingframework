function testModelInput(model, input) {
  var el = element(by.model(model));
  el.sendKeys(input);
  expect(el.getAttribute('value')).toContain(input);
}

var EC = protractor.ExpectedConditions;
// spec.js
describe('Login page', function() {
  // using browser.driver because login page is not Angular application
  it('should login correctly', function() {
    browser.driver.get('http://dev.assignforce.revaturelabs.com/');
    var VPUsername = "test.vpoftech@revature.com.int1";
    var VPPassword = "yuvi1712";
    var TrainerUsername = "test.trainer@revature.com.int1";
    var TrainerPassword = "trainer123";
    browser.driver.findElement(by.id('username')).sendKeys(VPUsername);
    browser.driver.findElement(by.id('password')).sendKeys(VPPassword);
    browser.driver.findElement(by.id('Login')).click();
  });
});

describe('Overview page', function(){
  it('should be appearing', function() {
    // Waits for the URL to match /home.
    browser.wait(EC.urlContains('/home'), 5000);
  });
});

describe('Batches page', function(){
  it('should be appearing', function(){
    browser.get('http://dev.assignforce.revaturelabs.com/batches');
    // Waits for the URL to match /batches
    browser.wait(EC.urlContains('/batches'), 5000);
  });
  it('should input curriculum', function(){
    testModelInput('bCtrl.batch.curriculum', '.NET');
  });
  it('should input focus', function(){
    var curriculum = element(by.model('bCtrl.batch.focus'));
    var opts = element(by.repeater('skills in bCtrl.skills'));
    curriculum.sendKeys('No Focus');
    expect(curriculum.getAttribute('value')).toBe('No Focus');
  });
  it('should input start date', function(){
    testModelInput('bCtrl.batch.startDate', '12/11/2017');
  });
  it('should input end date', function(){
    testModelInput('bCtrl.batch.endDate', '03/09/2018');
  });
  it('should have accurate week span', function(){
    var span = element(by.model('bCtrl.batch.weekSpan'));
    expect(span.getAttribute('value')).toContain('13');
  });
  it('should have a specific batch name', function(){
    var name = element(by.model('bCtrl.batch.name'));
    expect(name.getAttribute('value')).toContain('1712 Dec11 .NET');
  });
  it('should take batch name input', function(){
    testModelInput('bCtrl.batch.name', 'test name');
  });
  it('should take batch trainer input', function(){
    testModelInput('bCtrl.batch.trainer', 'Tom Brady');
  });
  it('should take batch co-trainer input', function(){
    testModelInput('bCtrl.batch.cotrainer', 'Matt Barkley');
  });
  it('should take batch location input', function(){
    testModelInput('bCtrl.batch.location', 'Revature HQ - Reston, VA');
  });
  it('should take batch building input', function(){
    testModelInput('bCtrl.batch.building', 'Training');
  });
  it('should take batch room input', function(){
    testModelInput('bCtrl.batch.room', '110');
  });
});
