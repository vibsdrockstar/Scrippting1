@Component({
  selector: 'hello-world'
})
@View({
  template: '<div>Hello {{name}}</div>' }) 
class HelloComponent({ 
  name: 'Calvin Hobbes' 
}) 
bootstrap(HelloComponent);
