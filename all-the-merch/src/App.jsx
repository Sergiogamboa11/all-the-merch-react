import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import { Shop } from './pages/shop/Shop'
import { Cart } from './pages/cart/Cart'
import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';

function App() {
  return (
    <div className="App">
      <Navbar className="bg-body-tertiary">
        <Container>
          <Navbar.Brand href="/">AllTheMerch</Navbar.Brand>
          <Navbar.Toggle />
          <Navbar.Collapse className="justify-content-end">
            <Navbar.Text>
              <a href="/cart">Cart</a>
            </Navbar.Text>
          </Navbar.Collapse>
        </Container>
      </Navbar>
      <Router>
        <Routes>
          <Route path="/" element={<Shop />} />
          <Route path="/cart" element={<Cart />} />
        </Routes>
      </Router>
    </div>
  )
}

export default App
